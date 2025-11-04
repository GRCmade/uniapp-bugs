import http from '@ohos.net.http';
import { BusinessError } from '@kit.BasicServicesKit';
import buffer from "@ohos.buffer";
import hilog from '@ohos.hilog';
import { log } from './utils';

@Entry
@Component
struct Index {
  @State message: string = 'click';

  build() {
    RelativeContainer() {
      Button(this.message)
        .onClick(() => {
          let httpRequest = http.createHttp();
          const bufs = [] as buffer.Buffer[];
          httpRequest.on('dataReceive', (data) => {
            bufs.push(buffer.from(data));
          });
          httpRequest.requestInStream("https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/test.json", (err: BusinessError, statusCode: number) => {
            if (!err) {
              console.info("requestInStream OK! ResponseCode is " + JSON.stringify(statusCode));
              const responseData = buffer.concat(bufs);
              let data: ArrayBuffer | string | object = '';
              data = responseData.toString('utf8');
              data = JSON.parse(data as string);
              hilog.info(0xaaa,'123',JSON.stringify(data))
              if(Array.isArray(data)){
                hilog.info(0xaaa,'123',data?.length.toString())
                log(JSON.stringify(data))
              }
            } else {

            }
          })
        })
    }
  }
}
