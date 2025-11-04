#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

/**
 * 生成精确20MB的JSON文件
 */
function generateExact20MBJson() {
  const targetSize = 29 * 1024 * 1024; // 20MB
  const outputPath = path.join(__dirname, '../test-data/large-data-61mb.json');

  // 确保输出目录存在
  const outputDir = path.dirname(outputPath);
  if (!fs.existsSync(outputDir)) {
    fs.mkdirSync(outputDir, { recursive: true });
  }

  console.log('生成精确20MB的JSON文件...');

  // 创建一个简单的对象模板
  const createItem = (index) => ({
    id: index,
    name: `Item ${index}`,
  });

  // 先计算一个对象的大小
  const sampleObject = createItem(1);
  const objectSize = JSON.stringify(sampleObject).length + 1; // +1 for comma
  console.log(`单个对象大小约: ${objectSize} bytes`);

  // 计算需要多少个对象（考虑JSON数组的额外字符）
  const arrayOverhead = 10; // 数组括号、换行等
  const availableSpace = targetSize - arrayOverhead;
  const itemCount = Math.floor(availableSpace / objectSize);

  console.log(`将生成 ${itemCount} 个对象`);

  // 使用流式写入来处理大文件
  const writeStream = fs.createWriteStream(outputPath);

  return new Promise((resolve, reject) => {
    writeStream.write('[\n');

    let currentSize = 2; // 起始括号和换行
    let itemsWritten = 0;

    const writeNextBatch = () => {
      let batchData = '';
      const batchSize = 1000; // 每批写入1000个对象

      for (let i = 0; i < batchSize && itemsWritten < itemCount; i++) {
        const item = createItem(itemsWritten + 1);
        const itemJson = JSON.stringify(item, null, 2);
        const itemWithComma = itemsWritten === itemCount - 1 ? itemJson : itemJson + ',';

        batchData += '  ' + itemWithComma.split('\n').join('\n  ') + '\n';
        itemsWritten++;
      }

      if (batchData) {
        writeStream.write(batchData);
        currentSize += Buffer.byteLength(batchData, 'utf8');

        const progress = (itemsWritten / itemCount * 100).toFixed(1);
        process.stdout.write(`\r进度: ${progress}% (${itemsWritten}/${itemCount})`);

        if (itemsWritten < itemCount) {
          setImmediate(writeNextBatch);
        } else {
          writeStream.write(']');
          writeStream.end();
        }
      } else {
        writeStream.write(']');
        writeStream.end();
      }
    };

    writeStream.on('finish', () => {
      const fileSize = fs.statSync(outputPath).size;
      const fileSizeMB = (fileSize / (1024 * 1024)).toFixed(2);

      console.log('\n✅ 文件生成完成！');
      console.log(`📁 文件路径: ${outputPath}`);
      console.log(`📊 文件大小: ${fileSizeMB}MB (${fileSize} bytes)`);
      console.log(`📈 数组长度: ${itemsWritten}`);

      resolve({
        path: outputPath,
        size: fileSize,
        sizeMB: fileSizeMB,
        itemCount: itemsWritten
      });
    });

    writeStream.on('error', reject);

    // 开始写入
    writeNextBatch();
  });
}

// 如果直接运行此脚本
if (require.main === module) {
  generateExact20MBJson()
    .then(result => {
      console.log('✅ 生成成功！');

      // 验证JSON格式
      try {
        const content = fs.readFileSync(result.path, 'utf8');
        const parsed = JSON.parse(content);
        console.log(`✅ JSON格式验证成功，数组包含 ${parsed.length} 个元素`);
      } catch (error) {
        console.error('❌ JSON格式验证失败:', error.message);
      }
    })
    .catch(error => {
      console.error('❌ 生成失败:', error);
      process.exit(1);
    });
}

module.exports = generateExact20MBJson;
