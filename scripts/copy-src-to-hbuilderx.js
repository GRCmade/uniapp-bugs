const fs = require('fs-extra');
const path = require('path');

const srcDir = path.resolve(__dirname, '../src');
const destDir = path.resolve(__dirname, '../now-hbuilderx');

// 确保目标目录存在
fs.ensureDirSync(destDir);

// 复制src目录到now-hbuilderx
try {
  fs.copySync(srcDir, destDir, {
    overwrite: true,
    errorOnExist: false,
    dereference: true,
    preserveTimestamps: true,
  });
  console.log('✅ 成功将src目录内容复制到now-hbuilderx目录');
} catch (err) {
  console.error('❌ 复制过程中出错:', err);
} 