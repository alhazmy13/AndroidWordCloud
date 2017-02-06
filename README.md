
</p>
# Android Word Cloud
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/packagist/l/doctrine/orm.svg)
![](https://img.shields.io/badge/version-0.2.0_beta-blue.svg)

------

## Screenshots 
  <img src="https://cloud.githubusercontent.com/assets/4659608/20027390/5e40ecf6-a324-11e6-95e4-31dfe850c49b.png" width="400">
  <img src="https://cloud.githubusercontent.com/assets/4659608/20027391/5e76fd3c-a324-11e6-99d9-14fae8c85838.png" width="400">

## Installation

**Maven**

```xml
<dependency>
<groupId>net.alhazmy13.wordcloud</groupId>
<artifactId>library</artifactId>
<version>0.2.0-beta</version>
</dependency>
```


**Gradle**

```gradle
dependencies {
	compile 'net.alhazmy13.wordcloud:library:0.2.0-beta'
}
```

## Usage
To use the library, you must include the WordCloudView class in your project. A simple solution is to reference it directly into your layout:

```xml
<net.alhazmy13.wordcloud.WordCloudView
       android:id="@+id/wordCloud"
       android:layout_width="match_parent"
       android:layout_height="match_parent" />
```

Then, within your code, fetch the view and initialize it:

```java
WordCloudView wordCloud = (WordCloudView) findViewById(R.id.wordCloud);
        wordCloud.setDataSet(list);
        wordCloud.notifyDataSetChanged();
```

And make sure to call `notifyDataSetChanged` to update view.

## Additional Options 
###Setting Color

there's two option to change the colors, either by passing an array of `int` or by using a predefined colors from `ColorTemplate` class

```java
wordCloud.setColors(ColorTemplate.MATERIAL_COLORS);
//OR
wordCloud.setColors(new int[] {Color.BLUE, Color.GRAY, Color.GREEN, Color.CYAN });
```
###Setting Scale Values

```java
wordCloud.setScale(MAX,MIN);
```

## Features to be added:
- `onClickEvent` for each word.
- ~~Custom color for each word~~.
- Custom font.

## Credits 
- [d3-cloud](https://github.com/jasondavies/d3-cloud)

