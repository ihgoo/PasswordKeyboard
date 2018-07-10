# passwordKeyboard
> passwordKeyboard是一个简单的自定义数字键盘。

[![](https://jitpack.io/v/ihgoo/PasswordKeyboard.svg)](https://jitpack.io/#ihgoo/PasswordKeyboard)


### 引入
* Gradle

 ```
 allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	implementation 'com.github.ihgoo:PasswordKeyboard:-SNAPSHOT'
}
```

### 使用
#### 基础用法

```
xml
   <project.com.password_keyboard.view.PasswordKeyboardView
        android:id="@+id/keyboardView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```



#### 支持以下两个自定义属性

| Name                 | Type      | Default      | Description                                                        |
|----------------------|-----------|--------------|--------------------------------------------------------------------|
| shuffle            | `boolean`  | `false` | 设置密码乱序（true为乱序，false为正常）|
| pwdLength            | `integer`  | `6` | 设置密码长度|




#### 参数说明

* ` OnOloseClickListener.onCloseClick`: 数字键盘关闭按钮的监听
* ` OnKeybordClickListener.onNumberClick`: 数字键盘按钮的监听(仅支持数字)
* ` OnKeybordClickListener.onDeleteClick`: 数字键盘删除按钮的监听
* ` OnPasswordCallBack.wholePassword`: 完整密码输入完成的回调
* ` PasswordKeyboardView.setPwdLength`: 设置密码长度（也可以在xml中设置，见自定义属性）
* ` PasswordKeyboardView.setShuffle`: 设置密码乱序（true为乱序，false为正常）（也可以在xml中设置，见自定义属性）
* ` PasswordKeyboardView.rebuild`: 重新构建布局，调用 `setPwdLength` 和 `setShuffle` 方法后只需要调用一次rebuild即可。






### 效果图

![device-2018-07-03-133938.png](https://i.loli.net/2018/07/03/5b3b0c36a05d1.png)

乱序排列

![device-2018-07-03-132656.png](https://i.loli.net/2018/07/03/5b3b09887ffdc.png)

正序排列

## 更新日志

* v_1.0.0 更新
	* 完善功能

## TODO LIST
- [x] 键盘随机性
- [ ] 字母键盘
- [ ] 兼容自定义布局
