const PAGE_PATH = '/pages/API/get-system-info/get-system-info'

describe('ExtApi-GetSystemInfo', () => {

  let page;
  let res;
  const stringProperties = [
    'appId', 'appLanguage', 'appName', 'appVersion', 'appVersionCode',
    'brand', 'deviceId', 'deviceBrand', 'deviceModel', 'deviceType', 'language',
    'model', 'osName', 'osVersion', 'osLanguage', 'platform', 'system', 'ua', 'uniCompilerVersion',
    'uniPlatform', 'uniRuntimeVersion', 'romName', 'romVersion',
  ]
  const numberProperties = [
    'osAndroidAPILevel', 'devicePixelRatio', 'pixelRatio', 'screenWidth', 'screenHeight', 'statusBarHeight',
    'windowWidth',
    'windowHeight', 'windowTop', 'windowBottom', 'screenTop',
    'uniCompilerVersionCode', 'uniRuntimeVersionCode'
  ]
  const booleanProperties = [
  ]
  const requiredProperties = [
    'uniCompilerVersion',
    'uniCompilerVersionCode',
    'uniRuntimeVersion',
    'uniRuntimeVersionCode'
  ]

  beforeAll(async () => {
    page = await program.reLaunch(PAGE_PATH)
    await page.waitFor(600);
    res = await page.callMethod('jest_getSystemInfo')
  });
  it('Check GetSystemInfoSync', async () => {
    for (const key in res) {
      const value = res[key];
      console.log("key :",key , "value :", value);
      if (stringProperties.indexOf(key) != -1) {
        expect(value).not.toBeNull();
        expect(value).not.toBe("");
      }
      if (numberProperties.indexOf(key) != -1) {
        expect(value).not.toBeNull();
        expect(value).toBeGreaterThanOrEqual(0);
      }
      if (booleanProperties.indexOf(key) != -1) {
        expect(value).not.toBeNull();
        expect(typeof value).toBe('boolean');
      }
      if (key == 'deviceOrientation') {
        expect(['portrait', 'landscape']).toContain(value);
      }
      if (key == "osTheme") {
        expect(['light', 'dark']).toContain(value);
      }
      if (key == "appTheme") {
        expect(['light', 'dark', 'auto']).toContain(value);
      }
    }
  });
  it('Check GetSystemInfoSync required properties', async () => {
    for (let i = 0; i < requiredProperties.length; i++) {
      const key = requiredProperties[i]
      expect(`${key} not null: ${res[key] != null}`).toBe(`${key} not null: true`)
    }
  })
});
