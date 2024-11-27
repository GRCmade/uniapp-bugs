
import { MqttClientOptions } from '@ohos/mqtt/src/main/cpp/types/libmqttasync'
declare interface Uni {
  /**
   * 获取设备电量
   *
   * @tutorial https://uniapp.dcloud.net.cn/api/system/batteryInfo.html
   */
  mqttUtil(option?: MqttClientOptions);
}
