# TitledLayout

[![](https://jitpack.io/v/criske/TitledLayout.svg)](https://jitpack.io/#criske/TitledLayout)

Rough implemetation of titled layout in android.

```xml
 <com.crskdev.lib.titledlayout.TitledLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_content="@layout/my_content"
        app:title="My Title"
        tools:context=".MainActivity" />
```
![](https://imgur.com/i4Ugpz4.jpg)


```gradle
allprojects {
	repositories {maven { url 'https://jitpack.io' }}
}
implementation 'com.github.criske:TitledLayout:1.0'
```
