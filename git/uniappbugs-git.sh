#!/bin/bash

git -v

# 提示用户输入路径和分支名称
read -p "请输入项目路径: " PROJECT_PATH
read -p "请输入分支名称: " BRANCH_NAME

# 检验输入是否为空
if [ -z "$PROJECT_PATH" ] || [ -z "$BRANCH_NAME" ]; then
  echo "路径和分支名称不能为空"
  exit 1
fi

# 检验路径是否存在
if [ ! -d "$PROJECT_PATH" ]; then
  echo "路径不存在: $PROJECT_PATH"
  exit 1
fi

cd "$PROJECT_PATH"
# 先删除.git文件夹
rm -rf .git
# 初始化git
git init
git checkout -b "$BRANCH_NAME"
git add .
git commit -m "Initial commit"
git remote add origin git@github.com:GRCmade/uniapp-bugs.git
git push -u origin "$BRANCH_NAME"