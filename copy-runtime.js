const a = "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-now-cli/dist/build/app-harmony"
const b = "/Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/entry/src/main/resources/resfile/apps/HBuilder/www"

// 写一个脚本，把 a 文件夹下的所有文件拷贝到 b 文件夹下

const fs = require('fs');
const path = require('path');

function copyFiles(src, dest) {
    if (!fs.existsSync(dest)) {
        fs.mkdirSync(dest, { recursive: true });
    }

    const entries = fs.readdirSync(src, { withFileTypes: true });

    for (let entry of entries) {
        const srcPath = path.join(src, entry.name);
        const destPath = path.join(dest, entry.name);

        if (entry.isDirectory()) {
            copyFiles(srcPath, destPath);
        } else {
            try {
                fs.copyFileSync(srcPath, destPath);
            } catch (err) {
                if (err.code === 'ENOTSUP') {
                    console.error(`Skipping unsupported file: ${srcPath}`);
                } else if (err.code === 'EACCES') {
                    console.error(`Permission denied: ${srcPath}`);
                } else {
                    throw err;
                }
            }
        }
    }
}

copyFiles(a, b);