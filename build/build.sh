rm -rf dist/build
npx uni build -p app
appid=$(< src/manifest.json grep -vE "\/\*|^\s+\/\/" | jq -r .appid)
# 获取appVersion
appVersion=$(< src/manifest.json grep -vE "\/\*|^\s+\/\/" | jq -r .versionName)
echo "appid 为：${appid}"
echo "appVersion 为：${appVersion}"
if [ -d dist/build/app ]; then
    cd dist/build || exit
    rm -rf "$appid".*
    mv app "$appid"
    cd "$appid" || exit
    zip -r "$appid".zip ./
    mv "$appid".zip ../"$appid".wgt
    cd ..
    
    # 根据参数判断打包方式
    if [ "$1" = "h" ]; then
        # 鸿蒙开发打包
        echo "执行鸿蒙开发打包..."
        cp -f "$appid".wgt ~/Downloads/mashangban/entry/src/main/resources/resfile
    else
        # 正常发包
        echo "执行正常发包..."
        zip "$appid"_v"$appVersion".wgt.zip "$appid".wgt
        cp -f "$appid"_v"$appVersion".wgt.zip ~/Downloads/
    fi
fi
