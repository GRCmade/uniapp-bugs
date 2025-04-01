const express = require("express");
const cors = require("cors");
const path = require('path');
const app = express();
const port = 3000;
const os = require("os");
const http = require("http");
const WebSocket = require("ws");
const multer = require("multer");
const fs = require('fs');

// 设置 multer 存储配置
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'upload/'); // 修改存储路径为 file 文件夹
  },
  filename: function (req, file, cb) {
    cb(null, Date.now() + '-' + file.originalname);
  }
});
const upload = multer({ storage: storage });

// 获取本地IP地址
function getLocalIPAddress() {
  const interfaces = os.networkInterfaces();
  for (const iface of Object.values(interfaces)) {
    for (const alias of iface) {
      if (alias.family === "IPv4" && !alias.internal) {
        return alias.address;
      }
    }
  }
  return "localhost";
}

// 启用所有CORS请求
app.use(cors());

app.get("/", (req, res) => {
  res.send("Hello World!");
});

function objectToString(obj) {
  return JSON.stringify(obj);
}

// 示例对象
const exampleObject = {
  key: "2e3b20b33c78f41be52c77604353a840",
  policyName: "原价",
  showSeats: [
    {
      salePrice: 300,
      snapshot: "十三区/7排15号",
      fareLevel: "D",
      suitCode: null,
      id: "1858723170526990337",
      price: 300,
      fareLevelVerboseName: "乙级票",
    },
  ],
  totalAmount: 300,
  deltaPrice: 0,
  buyProtocolOn: false,
  buyProtocol: "Empty_String",
  imageUrl:
    "https://res.dasheng.top/227/pro/ctms_tool/20241208/jpg/cebd003085e94068bfad67db82ba752a.jpg",
  name: "【南京】2024-2025赛季CBA联赛常规赛南京赛区赛事",
  venueAddress: "江苏省南京市鼓楼区华侨路街道双沟珍宝坊体育馆",
  realNameType: "3",
  id: "1838480455383248898",
  performanceSource: null,
  showTime: "2024-12-18 19:35:00",
  showName: "2024-12-18 19:35 南京头排苏酒 VS 广东东阳光",
  showId: "1858723021008441345",
  douyinProductId: "7421175268624140326",
  ticketOutletId: "",
  plugInType: 1,
};


app.get('/api/data', (req, res) => {
  // 手动转换为字符串
  const jsonString = JSON.stringify(exampleObject) + "1";
  console.log(jsonString+"111",typeof jsonString);
  
  // 设置响应头，并返回字符串
  res.setHeader('Content-Type', "text/plain");
  res.send(jsonString); // 返回字符串
});

// 处理文件上传
app.post('/uploadfile', upload.single('file'), (req, res) => {
  console.log(req.file);
  res.send({
    message: 'File uploaded successfully',
    filename: req.file.filename
  });
});

// 上传多个文件
app.post('/uploadfiles', upload.array('file', 10), (req, res) => {
  try {
    console.log("files", req.files);
    res.send({
      message: 'Files uploaded successfully',
      filenames: req.files.map(file => file.filename)
    });
  } catch (error) {
    console.error("上传文件错误:", error);
    res.status(400).send({
      message: '文件上传失败',
      error: error.message
    });
  }
});

// 处理文件上传并转换为 base64 编码
app.post('/uploadbase64', upload.single('file'), (req, res) => {
  const filePath = req.file.path;
  fs.readFile(filePath, (err, data) => {
    if (err) {
      return res.status(500).send({ message: 'File read error' });
    }
    const base64Image = data.toString('base64');
    res.send({
      message: 'File uploaded and converted to base64 successfully',
      filename: req.file.filename,
      base64: base64Image
    });
  });
});


const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

wss.on("connection", (ws) => {
  console.log("WebSocket connection established");

  ws.on("message", (message) => {
    console.log(`Received message: ${message}`);
    ws.send(`Server received: ${message}`);
  });

  ws.on("close", () => {
    console.log("WebSocket connection closed");
  });
});

// 文件路径
const filePath = path.join(__dirname, '/file/uni-app.pdf');

// 处理文件下载请求
app.get('/download/header', (req, res) => {
  // 检查文件是否存在
  if (fs.existsSync(filePath)) {
    // 设置响应头
    res.setHeader('Content-Disposition', 'attachment; filename=uni-app1.pdf');
    res.setHeader('Content-Type', 'application/pdf');

    // 创建一个文件流并将文件内容发送给客户端
    const fileStream = fs.createReadStream(filePath);
    fileStream.pipe(res);
  } else {
    // 如果文件不存在，返回 404 错误
    res.status(404).send('File not found');
  }
});

// 处理文件下载请求
app.get('/download/header1', (req, res) => {
  // 检查文件是否存在
  if (fs.existsSync(filePath)) {
    // 设置响应头
    res.setHeader('Content-Disposition', 'attachment; filename="uni-app-h1.pdf"');
    res.setHeader('Content-Type', 'application/pdf');

    // 创建一个文件流并将文件内容发送给客户端
    const fileStream = fs.createReadStream(filePath);
    fileStream.pipe(res);
  } else {
    // 如果文件不存在，返回 404 错误
    res.status(404).send('File not found');
  }
});

// 处理文件下载请求
app.get('/download/header2', (req, res) => {
  // 检查文件是否存在
  if (fs.existsSync(filePath)) {
    // 设置响应头
    res.setHeader('Content-Disposition', "attachment; filename='uni-app-h2.pdf'");
    res.setHeader('Content-Type', 'application/pdf');

    // 创建一个文件流并将文件内容发送给客户端
    const fileStream = fs.createReadStream(filePath);
    fileStream.pipe(res);
  } else {
    // 如果文件不存在，返回 404 错误
    res.status(404).send('File not found');
  }
});

// 处理文件下载请求
app.get('/download/header3', (req, res) => {
  // 检查文件是否存在
  if (fs.existsSync(filePath)) {
    // 设置响应头
    res.setHeader('Content-Disposition', "attachment; filename=\"uni-app-h2.pdf\"");
    res.setHeader('Content-Type', 'application/pdf');

    // 创建一个文件流并将文件内容发送给客户端
    const fileStream = fs.createReadStream(filePath);
    fileStream.pipe(res);
  } else {
    // 如果文件不存在，返回 404 错误
    res.status(404).send('File not found');
  }
});

// 处理文件下载请求
app.get('/download/header4', (req, res) => {
  // 检查文件是否存在
  if (fs.existsSync(filePath)) {
    // 设置响应头
    res.setHeader('Content-Disposition', "attachment; filename=\"\"");
    res.setHeader('Content-Type', 'application/pdf');

    // 创建一个文件流并将文件内容发送给客户端
    const fileStream = fs.createReadStream(filePath);
    fileStream.pipe(res);
  } else {
    // 如果文件不存在，返回 404 错误
    res.status(404).send('File not found');
  }
});

// 处理文件下载请求
app.get('/download/senfile', (req, res) => {
  res.sendFile(filePath)
});

app.use('/file', express.static(path.join(__dirname, 'file')));

// 添加错误处理中间件
app.use((err, req, res, next) => {
  if (err instanceof multer.MulterError) {
    if (err.code === 'LIMIT_UNEXPECTED_FILE') {
      return res.status(400).send({
        message: '字段名称错误。对于多文件上传，请使用字段名 "files"'
      });
    }
    return res.status(400).send({
      message: '文件上传错误',
      error: err.message
    });
  }
  next(err);
});

server.listen(port, () => {
  const localIP = getLocalIPAddress();
  console.log(`Server is running at http://${localIP}:${port}`);
});
