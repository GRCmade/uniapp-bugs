#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

/**
 * 生成指定大小的JSON文件（默认20MB）
 */
function generateJsonFile(targetSizeMB = 20) {
  const targetSize = targetSizeMB * 1024 * 1024;
  const outputPath = path.join(__dirname, '../test-data', `data-${targetSizeMB}mb.json`);

  // 确保输出目录存在
  const outputDir = path.dirname(outputPath);
  if (!fs.existsSync(outputDir)) {
    fs.mkdirSync(outputDir, { recursive: true });
  }

  console.log(`🚀 开始生成 ${targetSizeMB}MB 的JSON文件...`);
  console.log(`📁 输出路径: ${outputPath}`);

  // 创建一个简单但足够大的对象
  const createItem = (index) => ({
    id: index,
    title: `标题${index}`,
    content: `这是第${index}条数据的内容，包含中文字符以增加文件大小。`.repeat(2),
    timestamp: Date.now() + index,
    category: `分类${index % 10}`,
    author: `作者${index % 100}`,
    tags: [`tag${index % 20}`, `label${index % 15}`, `type${index % 8}`],
    metadata: {
      views: Math.floor(Math.random() * 10000),
      likes: Math.floor(Math.random() * 1000),
      shares: Math.floor(Math.random() * 100),
      comments: Math.floor(Math.random() * 500)
    }
  });

  // 先测试一个对象的大小
  const testItem = createItem(1);
  const itemJsonString = JSON.stringify(testItem);
  const itemSize = Buffer.byteLength(itemJsonString, 'utf8') + 3; // +3 for comma, spaces, newline

  console.log(`📏 单个对象大小: ${itemSize} bytes`);

  // 计算需要的对象数量（留出一些空间给JSON数组结构）
  const structureOverhead = 100; // JSON数组的括号、缩进等
  const maxItems = Math.floor((targetSize - structureOverhead) / itemSize);

  console.log(`📊 计划生成 ${maxItems} 个对象`);

  const data = [];
  const startTime = Date.now();

  // 生成数据
  for (let i = 1; i <= maxItems; i++) {
    data.push(createItem(i));

    if (i % 5000 === 0) {
      const progress = (i / maxItems * 100).toFixed(1);
      process.stdout.write(`\r⏳ 生成进度: ${progress}% (${i}/${maxItems})`);
    }
  }

  console.log(`\n📝 开始写入文件...`);

  // 写入文件
  const jsonString = JSON.stringify(data, null, 2);
  fs.writeFileSync(outputPath, jsonString, 'utf8');

  // 检查结果
  const stats = fs.statSync(outputPath);
  const actualSize = stats.size;
  const actualSizeMB = (actualSize / (1024 * 1024)).toFixed(2);
  const generationTime = Date.now() - startTime;

  console.log(`\n✅ 文件生成完成！`);
  console.log(`📁 文件路径: ${outputPath}`);
  console.log(`📊 实际大小: ${actualSizeMB}MB (${actualSize.toLocaleString()} bytes)`);
  console.log(`📈 数组长度: ${data.length.toLocaleString()}`);
  console.log(`⏱️  生成耗时: ${generationTime}ms`);
  console.log(`🎯 目标达成率: ${(actualSize / targetSize * 100).toFixed(1)}%`);

  // 验证JSON
  try {
    const content = fs.readFileSync(outputPath, 'utf8');
    const parsed = JSON.parse(content);
    if (Array.isArray(parsed)) {
      console.log(`✅ JSON验证成功: 数组包含 ${parsed.length.toLocaleString()} 个元素`);
      console.log(`🔍 第一个元素: ${JSON.stringify(parsed[0], null, 2).substring(0, 100)}...`);
    } else {
      console.log(`⚠️  警告: 根元素不是数组`);
    }
  } catch (error) {
    console.error(`❌ JSON验证失败: ${error.message}`);
  }

  return {
    path: outputPath,
    targetSize,
    actualSize,
    itemCount: data.length,
    generationTime
  };
}

// 命令行参数支持
if (require.main === module) {
  const args = process.argv.slice(2);
  const sizeMB = args[0] ? parseFloat(args[0]) : 20;

  if (isNaN(sizeMB) || sizeMB <= 0) {
    console.error('❌ 请提供有效的文件大小（MB）');
    console.log('📖 用法: node generate-json-file.js [大小MB]');
    console.log('📖 例如: node generate-json-file.js 20');
    process.exit(1);
  }

  generateJsonFile(sizeMB);
}

module.exports = generateJsonFile;
