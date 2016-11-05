
</p>
# Android Word Cloud
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/packagist/l/doctrine/orm.svg)
![](https://img.shields.io/badge/version-0.1.1_beta-blue.svg)
<p align="center">
<img width="600" alt="wordcloud-2" src="https://cloud.githubusercontent.com/assets/4659608/20030747/4f1aae08-a37c-11e6-9fc4-ceec6ee7fe01.png">
</p>


------

## Screenshots 
  <img src="https://cloud.githubusercontent.com/assets/4659608/20027390/5e40ecf6-a324-11e6-95e4-31dfe850c49b.png" width="400">
  <img src="https://cloud.githubusercontent.com/assets/4659608/20027391/5e76fd3c-a324-11e6-99d9-14fae8c85838.png" width="400">

## Installation

**Maven**

```xml
<dependency>
<groupId>net.alhazmy13.wordclouds</groupId>
<artifactId>library</artifactId>
<version>0.1.1-beta</version>
</dependency>
```


**Gradle**

```gradle
dependencies {
	compile 'net.alhazmy13.wordclouds:library:0.1.1-beta'
}
```

## Usage
To use the library, you must include the WordCloudView class in your project. A simple solution is to reference it directly into your layout:

```xml
<net.alhazmy13.wordclouds.WordCloudView
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

## Features to be added:
- `onClickEvent` for each word.
- ~~Custom color for each word~~.
- Custom font.


## Credits 
- [d3-cloud](https://github.com/jasondavies/d3-cloud)


## License
------

The MIT License (MIT)

Copyright (c) 2015 Abdullah Alhazmy

> Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

> The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
