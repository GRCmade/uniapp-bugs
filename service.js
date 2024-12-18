const express = require("express");
const cors = require("cors");
const multer = require("multer");
const app = express();
const port = 3000;
const os = require("os");

// 设置 multer 存储配置
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'file/'); // 修改存储路径为 file 文件夹
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

app.get("/api/jsontext", (req, res) => {
  // 手动转换为字符串
  const exampleObject =
    "%7B%22key%22:%22c60976ae59470c6c5cbc57d69af677ef%22,%22policyName%22:%22%E5%8E%9F%E4%BB%B7%22,%22showSeats%22:%5B%7B%22salePrice%22:100,%22snapshot%22:%22%E8%A5%BF%E5%8C%BA%E4%B8%8B%E7%9C%8B%E5%8F%B0/4%E6%8E%9241%E5%8F%B7%22,%22fareLevel%22:%22B%22,%22suitCode%22:null,%22id%22:%221860581840986537986%22,%22price%22:100,%22fareLevelVerboseName%22:%22B%E6%A1%A3%E6%AC%A1%22%7D%5D,%22totalAmount%22:100,%22deltaPrice%22:0,%22buyProtocolOn%22:false,%22buyProtocol%22:%22Empty_String%22,%22imageUrl%22:%22https://res.dasheng.top/227/pro/ctms_tool/20241020/png/ca005c3bcb5346cca742d23303f1619c.png%22,%22name%22:%22%E3%80%90%E5%8C%97%E4%BA%AC%E3%80%912024-2025%E4%B8%AD%E5%9B%BD%E6%8E%92%E7%90%83%E8%B6%85%E7%BA%A7%E8%81%94%E8%B5%9B%E5%8C%97%E4%BA%AC%E5%8C%97%E6%B1%BD%E7%94%B7%E6%8E%92%22,%22venueAddress%22:%22%E5%8C%97%E4%BA%AC%E5%B8%82%E6%9C%9D%E9%98%B3%E5%8C%BA%E5%85%AD%E9%87%8C%E5%B1%AF%E8%A1%97%E9%81%93%E6%9C%9D%E9%98%B3%E4%BD%93%E8%82%B2%E9%A6%86%22,%22realNameType%22:%223%22,%22id%22:%221847619394166296577%22,%22performanceSource%22:null,%22showTime%22:%222024-12-15%2019:30:00%22,%22showName%22:%222024-12-15%2019:30%20%E5%8C%97%E4%BA%AC%E5%8C%97%E6%B1%BD%E7%94%B7%E6%8E%92%20VS%20%E5%B1%B1%E4%B8%9C%E6%9D%BE%E5%B1%B1%E5%B0%8F%E9%95%87%E7%94%B7%E6%8E%92%22,%22showId%22:%221860581783100948482%22,%22douyinProductId%22:%227437383587948677130%22,%22ticketOutletId%22:%22%22,%22plugInType%22:null%7D";

  const jsonString = exampleObject;

  // 设置响应头，并返回字符串
  res.setHeader("Content-Type", "text/plain");
  res.send(jsonString); // 返回字符串
});

// 处理文件上传
app.post('/uploadfile', upload.single('file'), (req, res) => {
  res.send({
    message: 'File uploaded successfully',
    filename: req.file.filename
  });
});

app.listen(port, () => {
  const localIP = getLocalIPAddress();
  console.log(`Server is running at http://${localIP}:${port}`);
});
