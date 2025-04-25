/**
 * 创建一个新的git分支
 * git 分支的名称是： ../youtrack.json 文件中的 branch 字段
 * 如果分支已经存在，则不创建
 * 如果分支不存在，则创建
 * 之后，切换到该分支
 * 最后，提交该分支
 * 
 * 
 * 提交的信息，就是 youtrack.json 文件中的 branch 字段
 * 提供一个默认参数
 * 如果什么也不传，就上传所有的更改,并且推送到远程分支
 * 如果传入 commit 那么只上传暂存区的更改，并且提交
 * 如果传入 push 那么只上传暂存区的更改，并且提交，并且推送到远程分支
 * 
 */

const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

// 读取youtrack.json文件
const youtrackPath = path.resolve(__dirname, '../youtrack.json');
let youtrackData;

try {
  const fileContent = fs.readFileSync(youtrackPath, 'utf8');
  youtrackData = JSON.parse(fileContent);
} catch (error) {
  console.error('读取youtrack.json文件失败:', error.message);
  process.exit(1);
}

// 获取分支名称
const branchName = youtrackData.branch;
if (!branchName) {
  console.error('youtrack.json文件中没有指定branch字段');
  process.exit(1);
}

// 获取提交参数
const action = process.argv[2] || 'default';

// 执行git命令的函数
function execCommand(command) {
  try {
    return execSync(command, { encoding: 'utf8', stdio: 'pipe' });
  } catch (error) {
    console.error(`执行命令失败: ${command}`);
    console.error(error.stderr || error.message);
    return false;
  }
}

// 检查分支是否存在
function branchExists(branch) {
  try {
    const branches = execSync('git branch', { encoding: 'utf8' });
    return branches.split('\n').some(b => b.trim().replace('* ', '') === branch);
  } catch (error) {
    console.error('检查分支失败:', error.message);
    return false;
  }
}

// 主要逻辑
function main() {
  console.log(`处理分支: ${branchName}`);

  // 检查分支是否存在
  const exists = branchExists(branchName);

  if (exists) {
    console.log(`分支 ${branchName} 已存在，切换到该分支`);
    if (!execCommand(`git checkout ${branchName}`)) {
      process.exit(1);
    }
  } else {
    console.log(`创建并切换到新分支: ${branchName}`);
    if (!execCommand(`git checkout -b ${branchName}`)) {
      process.exit(1);
    }
  }

  // 根据参数执行不同的操作
  switch (action) {
    case 'commit':
      // 只提交暂存区的更改
      console.log('提交暂存区的更改');
      execCommand(`git commit -m "${branchName}"`);
      break;

    case 'push':
      // 提交暂存区并推送
      console.log('提交暂存区的更改并推送到远程');
      execCommand(`git commit -m "${branchName}"`);
      execCommand(`git push -u origin ${branchName}`);
      break;

    default:
      // 提交所有更改并推送到远程
      console.log('提交所有更改并推送到远程');
      execCommand('git add .');
      execCommand(`git commit -m "${branchName}"`);
      execCommand(`git push -u origin ${branchName}`);
      break;
  }

  console.log('操作完成');
}

// 执行脚本
main();

