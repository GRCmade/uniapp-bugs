/**
 * 写一个脚本
 * 把 package.json 中的 dependencies 中的 @dcloudio 的 依赖
 * 执行：- pnpm add @dcloudio/...@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/...
 * 并且 加入到 package.json 的 resolutions 中
 */

const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

// 项目根目录路径
const rootDir = path.resolve(__dirname, '..');
// package.json 文件路径
const packageJsonPath = path.join(rootDir, 'package.json');
// uni-app-next 本地路径
const uniAppNextPath = '/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages';

// 读取 package.json 文件
const packageJson = JSON.parse(fs.readFileSync(packageJsonPath, 'utf8'));

// 获取所有 @dcloudio 依赖
const dcloudDependencies = {};
const allDependencies = {
  ...packageJson.dependencies,
  ...packageJson.devDependencies
};

// 筛选出所有 @dcloudio 开头的依赖
Object.keys(allDependencies).forEach(dep => {
  if (dep.startsWith('@dcloudio/')) {
    dcloudDependencies[dep] = allDependencies[dep];
  }
});

console.log('找到以下 @dcloudio 依赖:');
console.log(dcloudDependencies);

// 创建 resolutions 对象（如果不存在）
if (!packageJson.resolutions) {
  packageJson.resolutions = {};
}

// 处理每个 @dcloudio 依赖
Object.keys(dcloudDependencies).forEach(dep => {
  // 获取包名（去掉 @dcloudio/ 前缀）
  const packageName = dep.replace('@dcloudio/', '');
  // 本地包路径
  const localPackagePath = `${uniAppNextPath}/${packageName}`;
  // 链接格式路径
  const linkPath = `link:${localPackagePath}`;
  
  // 检查本地包路径是否存在
  if (fs.existsSync(localPackagePath)) {
    try {
      // 更新 dependencies 或 devDependencies 中的依赖路径
      if (packageJson.dependencies && packageJson.dependencies[dep]) {
        packageJson.dependencies[dep] = linkPath;
        console.log(`已将 dependencies 中的 ${dep} 更新为 ${linkPath}`);
      } else if (packageJson.devDependencies && packageJson.devDependencies[dep]) {
        packageJson.devDependencies[dep] = linkPath;
        console.log(`已将 devDependencies 中的 ${dep} 更新为 ${linkPath}`);
      }
      
      // 更新 resolutions
      packageJson.resolutions[dep] = linkPath;
      console.log(`已将 ${dep} 添加到 resolutions: ${linkPath}`);
    } catch (error) {
      console.error(`处理 ${dep} 失败:`, error.message);
    }
  } else {
    console.warn(`警告: 本地路径不存在: ${localPackagePath}`);
  }
});

// 将更新后的 package.json 写回文件
fs.writeFileSync(packageJsonPath, JSON.stringify(packageJson, null, 2), 'utf8');
console.log('已更新 package.json 文件');

// 执行 pnpm install 以应用更改
try {
  console.log('执行 pnpm install 以应用更改...');
  execSync('pnpm install', { stdio: 'inherit', cwd: rootDir });
  console.log('pnpm install 执行完成');
} catch (error) {
  console.error('pnpm install 执行失败:', error.message);
}
