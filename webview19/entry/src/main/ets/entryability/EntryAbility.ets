import { AbilityConstant, ConfigurationConstant, UIAbility, Want } from '@kit.AbilityKit';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
import { createNWeb, setOSRuntime,init } from '../pages/sdk'
// import {myNodeController} from  '../pages/common'
import {WebBuilder} from '../pages/common'
import {getRealPath} from  "../res/sdk"
setOSRuntime({
  WebBuilder
})

const DOMAIN = 0x0000;
// let filesDir = "";
// function getFilesDir() :string{
//   return f;
// }

export default class EntryAbility extends UIAbility {
  onCreate(want: Want, launchParam: AbilityConstant.LaunchParam): void {
    this.context.getApplicationContext().setColorMode(ConfigurationConstant.ColorMode.COLOR_MODE_NOT_SET);
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onCreate');
  }

  onDestroy(): void {
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onDestroy');
  }

  onWindowStageCreate(windowStage: window.WindowStage): void {
    // Main window is created, set main page for this ability
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onWindowStageCreate');
    init()

    windowStage.loadContent('pages/Index', (err) => {
      let windowClass: window.Window = windowStage.getMainWindowSync();
      if (!windowClass) {
        console.info('windowClass is null');
        return;
      }
      // let baseNode = new myNodeController();
      // createNWeb('https://www.baidu.com', windowClass.getUIContext());
      createNWeb('file:///data/storage/el1/bundle/entry/resources/resfile/index.html', windowClass.getUIContext());
      if (err.code) {
        hilog.error(DOMAIN, 'testTag', 'Failed to load the content. Cause: %{public}s', JSON.stringify(err));
        return;
      }
      hilog.info(DOMAIN, 'testTag', 'Succeeded in loading the content.');
    });
  }

  onWindowStageDestroy(): void {
    // Main window is destroyed, release UI related resources
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onWindowStageDestroy');
  }

  onForeground(): void {
    // Ability has brought to foreground
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onForeground');
  }

  onBackground(): void {
    // Ability has back to background
    hilog.info(DOMAIN, 'testTag', '%{public}s', 'Ability onBackground');
  }
}
