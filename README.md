# uniapp-bugs-service
uniapp-bugs中一个模板

这个是服务器版本

## 建立一个Node服务器

1. 初始化项目：
    ```bash
    npm init -y
    ```

2. 安装必要的依赖：
    ```bash
    npm install express
    ```

3. 创建一个简单的服务器：
    ```javascript
    // server.js
    const express = require('express');
    const app = express();
    const port = 3000;

    app.get('/', (req, res) => {
        res.send('Hello World!');
    });

    app.listen(port, () => {
        console.log(`Server is running at http://localhost:${port}`);
    });
    ```

4. 启动服务器：
    ```bash
    node service.js
    ```

## 实现服务器修改后热刷

1. 安装nodemon：
    ```bash
    npm install -g nodemon
    ```

2. 使用nodemon启动服务器：
    ```bash
    nodemon service.js
    ```

## 启用跨域支持

1. 安装cors模块：
    ```bash
    npm install cors
    ```

2. 在服务器中启用CORS：
    ```javascript
    const cors = require('cors');
    app.use(cors());
    ```

