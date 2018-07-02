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


#### 参数说明

* ` OnOloseClickListener.onCloseClick`: 键盘关闭按钮监听
* ` OnKeybordClickListener.onNumberClick`: 数字键盘按钮监听(仅支持数字)
* ` OnKeybordClickListener.onDeleteClick`: 键盘删除按钮监听
* ` OnPasswordCallBack.wholePassword`: 完整密码的回调




### 效果图

![device-2018-07-02-183210.png](https://i.loli.net/2018/07/02/5b3a0065163fc.png)

## 更新日志

* v_1.0.0 更新
	* 完善功能

## TODO LIST
- [ ] 键盘随机性
- [ ] 字母键盘
- [ ] 兼容自定义布局
