import { openUniMP,isExistsUniMP, releaseWgtToRunPath } from '@dcloudio/uni-app-runtime';

interface  MPres {
  msg: string;
}

@Entry
@Component
struct Index {
  @State message: string = '__UNI__0112D49';
  @State idList: string[] = ['__UNI__FA9F83D','__UNI__0112D49','__UNI__3F0B853',"__UNI__BFD77B4"]
  build() {
    Column() {
      ForEach(this.idList,(item:string,index:number)=>{
        Text(item)
          .fontSize(30)
          .onClick(async ()=>{
            const mpId = item

            await new Promise<void>((resolve, reject) => {
              try {
                // 判断应用是否已释放到运行目录
                let isExists = isExistsUniMP(mpId)
                console.log("isExists:"+isExists)
                // 拼接wgt包路径
                let path = getContext().resourceDir + "/"+mpId+".wgt"
                // 释放 wgt 包到运行目录
                releaseWgtToRunPath(mpId,path, (code:number, data: object)=>{
                  console.log(JSON.stringify({code,data}))
                  resolve()
                })
              } catch(err){
                reject(err)
              }
            })
            // 启动小程序
            const mp = openUniMP(mpId,{
              capsuleMenuActionSheetItems: [
                {
                  id: '1',
                  title: 'title1'
                },
                {
                  id: '2',
                  title: 'title2'
                }
              ]
            })
            mp.on('menuItemClick',(id: string)=>{
              console.log('UniMP-menuItemClick: ' + id)
              if(id == '1'){
                mp.sendUniMPEvent("mp-event", {
                  a: 1,
                  b: "2"
                });
              }
            })
            mp.on('close',()=>{
              console.log('UniMP-close')
            })
            mp.on('show',()=>{
              console.log('UniMP-show')
            })
            mp.on('hide',()=>{
              console.log('UniMP-hide')
            })
            mp.on('uniMPEvent', (event, data:MPres, notify) => {
              console.log(`宿主收到小程序消息，事件：${event}，消息：${JSON.stringify(data)}`);
              if(event == 'unimp-event'){
                AlertDialog.show({
                  title:"UniMP",
                  message:"yuhe"
                })
              }
              notify('宿主成功接收小程序消息')
            })
          })
      })

    }
  }
}
