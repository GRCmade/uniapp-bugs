const express = require("express");
const cors = require("cors");
const app = express();
const port = 3000;
const os = require("os");
const http = require("http");
const WebSocket = require("ws");

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

server.listen(port, () => {
  const localIP = getLocalIPAddress();
  console.log(`Server is running at http://${localIP}:${port}`);
});
