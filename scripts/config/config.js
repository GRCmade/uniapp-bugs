const os = require('os');
const fs = require('fs');
const path = require('path');

// 用户配置文件路径
const LOCAL_CONFIG_PATH = path.join(__dirname, 'local-config.js');

// 默认仓库配置
const DefaultRepository = {
  next: "/Users/gaoruicheng/Documents/DcloudProject/uni-app-next",
  dev: "/Users/gaoruicheng/Documents/DcloudProject/uni-app-dev",
  hbuilderx_alpha: "/Applications/HBuilderX-Alpha.app/Contents/HBuilderX",
  hbuilderx_vue3_path: "/plugins/uniapp-cli-vite/node_modules/@dcloudio",
  hbuilderx_vue2_path: "/plugins/uniapp-cli/node_modules/@dcloudio",
  runtime_harmony: "/Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/entry/src/main/resources/resfile/apps/HBuilder/www"
}

// 获取仓库配置
function getRepository() {
  // 如果存在本地配置文件，使用本地配置
  if (fs.existsSync(LOCAL_CONFIG_PATH)) {
    try {
      const localConfig = require(LOCAL_CONFIG_PATH);
      return { ...DefaultRepository, ...localConfig };
    } catch (err) {
      console.warn(`加载本地配置文件失败: ${err.message}`);
    }
  }
  return DefaultRepository;
}

const Repository = getRepository();
console.log(Repository);

module.exports = {
  Repository
}
