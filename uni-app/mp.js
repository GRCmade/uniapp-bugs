const { Repository } = require('../config.js');
const path = require('path');
const fs = require('fs-extra');
const { exec } = require('child_process');

// 接收两个参数
const args = process.argv.slice(2);
const vueVersion = parseInt(args[0], 10);
const platform = args[1];

if (![2, 3].includes(vueVersion) || typeof platform !== 'string') {
  console.error('请提供有效的参数：数字（2 或 3）表示 Vue 版本，字符串表示小程序平台');
  process.exit(1);
}
const platforms = ['weixin','kuaishou',"toutiao","alipay","xhs"]
if(!platforms.includes(platform)){
  console.error('有效的参数：'+platforms.join('，'));
  process.exit(1);
}

const name = `uni-mp-${platform}`;
const paths = {
  2: {
    base: Repository.dev,
    resource: path.join(Repository.dev, "packages", name),
    target: path.join(Repository.hbuilderx_alpha, Repository.hbuilderx_vue2_path, name),
    command: `npm run build:mp-${platform}`
  },
  3: {
    base: Repository.next,
    resource: path.join(Repository.next, "packages", name),
    target: path.join(Repository.hbuilderx_alpha, Repository.hbuilderx_vue3_path, name),
    command: `npm run build ${platform}`
  }
}[vueVersion];

// 切换到相应的路径
process.chdir(paths.base);

// 运行 npm run build 命令
exec(paths.command, (error, stdout, stderr) => {
  if (error) {
    console.error(`执行出错: ${error}`);
    return;
  }
  console.log(`stdout: ${stdout}`);
  console.error(`stderr: ${stderr}`);

  // 将 resource_path 中的文件替换到 target_vue_path，排除 node_modules 目录
  fs.copy(paths.resource, paths.target, { 
    overwrite: true,
    filter: (src, dest) => !src.includes('node_modules')
  }, err => {
    if (err) {
      console.error(`复制文件出错: ${err}`);
    } else {
      console.log(`文件已成功复制到 ${paths.target}`);
    }
  });
});