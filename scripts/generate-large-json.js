#!/usr/bin/env node

const fs = require('fs');
const path = require('path');

/**
 * 生成大约20MB的JSON文件，包含一个大数组
 */
function generateLargeJsonFile() {
  const targetSize = 20 * 1024 * 1024; // 20MB in bytes
  const outputPath = path.join(__dirname, '../test-data/large-data.json');

  // 确保输出目录存在
  const outputDir = path.dirname(outputPath);
  if (!fs.existsSync(outputDir)) {
    fs.mkdirSync(outputDir, { recursive: true });
  }

  console.log('开始生成大型JSON文件...');
  console.log(`目标大小: ${targetSize / (1024 * 1024)}MB`);
  console.log(`输出路径: ${outputPath}`);

  // 创建一个示例对象模板
  const createSampleObject = (index) => ({
    id: index,
    name: `用户${index}`,
    email: `user${index}@example.com`,
    age: 18 + (index % 50),
    city: ['北京', '上海', '广州', '深圳', '杭州', '南京', '武汉', '成都'][index % 8],
    occupation: ['工程师', '设计师', '产品经理', '教师', '医生', '律师', '销售', '运营'][index % 8],
    hobbies: ['阅读', '运动', '旅游', '音乐', '电影', '游戏', '摄影', '绘画'].slice(0, (index % 4) + 1),
    profile: {
      bio: `这是用户${index}的个人简介，包含一些详细的描述信息，用于增加JSON文件的大小。这个用户喜欢各种活动，有着丰富的生活经历。`,
      preferences: {
        theme: index % 2 === 0 ? 'light' : 'dark',
        language: 'zh-CN',
        notifications: true,
        privacy: {
          showEmail: index % 3 === 0,
          showPhone: index % 4 === 0,
          allowMessages: true
        }
      },
      stats: {
        loginCount: Math.floor(Math.random() * 1000),
        lastLoginTime: new Date(Date.now() - Math.random() * 30 * 24 * 60 * 60 * 1000).toISOString(),
        totalPoints: Math.floor(Math.random() * 10000),
        level: Math.floor(index / 100) + 1
      }
    },
    tags: Array.from({ length: (index % 5) + 1 }, (_, i) => `标签${index}-${i}`),
    metadata: {
      createdAt: new Date(Date.now() - Math.random() * 365 * 24 * 60 * 60 * 1000).toISOString(),
      updatedAt: new Date().toISOString(),
      version: '1.0.0',
      source: 'auto-generated'
    }
  });

  // 估算单个对象的大小
  const sampleObject = createSampleObject(1);
  const sampleSize = JSON.stringify(sampleObject).length;
  console.log(`单个对象大小: ${sampleSize} bytes`);

  // 计算需要多少个对象（预留一些空间给JSON格式化）
  const estimatedCount = Math.floor(targetSize / (sampleSize * 1.1));
  console.log(`预计需要生成 ${estimatedCount} 个对象`);

  // 生成数据数组
  const data = [];

  console.log('正在生成数据...');
  const startTime = Date.now();

  for (let i = 1; i <= estimatedCount; i++) {
    data.push(createSampleObject(i));

    // 每1000个对象显示一次进度
    if (i % 1000 === 0) {
      const progress = (i / estimatedCount * 100).toFixed(1);
      process.stdout.write(`\r进度: ${progress}% (${i}/${estimatedCount})`);
    }
  }

  console.log('\n数据生成完成，开始写入文件...');

  // 写入JSON文件
  const jsonString = JSON.stringify(data, null, 2);
  fs.writeFileSync(outputPath, jsonString, 'utf8');

  const fileSize = fs.statSync(outputPath).size;
  const fileSizeMB = (fileSize / (1024 * 1024)).toFixed(2);
  const duration = Date.now() - startTime;

  console.log('\n✅ JSON文件生成成功！');
  console.log(`📁 文件路径: ${outputPath}`);
  console.log(`📊 文件大小: ${fileSizeMB}MB (${fileSize} bytes)`);
  console.log(`📈 数组长度: ${data.length}`);
  console.log(`⏱️  生成耗时: ${duration}ms`);

  // 验证JSON格式
  try {
    const parsed = JSON.parse(fs.readFileSync(outputPath, 'utf8'));
    console.log(`✅ JSON格式验证成功，包含 ${parsed.length} 个元素`);
  } catch (error) {
    console.error('❌ JSON格式验证失败:', error.message);
  }
}

// 支持命令行参数
if (require.main === module) {
  generateLargeJsonFile();
}

module.exports = generateLargeJsonFile;
