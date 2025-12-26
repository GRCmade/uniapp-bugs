import { AbilityConstant, ConfigurationConstant, UIAbility, Want } from '@kit.AbilityKit';
import { hilog } from '@kit.PerformanceAnalysisKit';
import { window } from '@kit.ArkUI';
// import type { BusinessError as BusinessError } from "@ohos:base";
// import OHWindow from "@ohos:window";
import { BusinessError } from "@ohos.base"
import { SECOND } from "../pages/Second"

const DOMAIN = 0x0000;

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
    const initWindow = (err: BusinessError, window: window.Window) => {
      window.setWindowLayoutFullScreen(true);
      windowStage.loadContent('pages/Index', async (err) => {

        if (err.code) {
          hilog.error(DOMAIN, 'testTag', 'Failed to load the content. Cause: %{public}s', JSON.stringify(err));
          return;
        }
        // window.showWindow()
        hilog.info(DOMAIN, 'testTag', 'Succeeded in loading the content.');
      });

      // setTimeout(() => {
      //   windowStage.loadContentByName(SECOND, async (err) => {
      //     // await new Promise<void>(r => setTimeout(r, 10));
      //     if (err.code) {
      //       hilog.error(DOMAIN, 'testTag', 'Failed to load the content. Cause: %{public}s', JSON.stringify(err));
      //       return;
      //     }
      //     window.showWindow()
      //     hilog.info(DOMAIN, 'testTag', 'Succeeded in loading the content.');
      //   });
      // }, 200)
    }
    windowStage.getMainWindow(initWindow)
  }

  onBackPressed(): boolean {
    return false
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
