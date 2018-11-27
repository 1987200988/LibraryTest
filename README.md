用法如下：
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  
  	dependencies {
	        implementation 'com.github.1987200988.LibraryTest:app:1.0.0'
	}
