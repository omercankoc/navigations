# Navigations

### Dependencies:

To add Safe Args to your project, include the following classpath in your top level build.gradle file.
```gradle
buildscript {
    repositories {
        google()
    }
    dependencies {
        def nav_version = "2.3.5"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
}
```

Add the dependencies for the artifacts you need in the build.gradle file for your app or module.
```gradle
def nav_version = "2.3.5"
implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
```

Add plugin,
```gradle
apply plugin: "androidx.navigation.safeargs.kotlin"
``` 
or
```gradle
plugins {
    id 'androidx.navigation.safeargs.kotlin'
}
```

### To Create Navigation:

res -> New -> Android Resource File -> Resource Type : Navigation

Fragments must then be added and their graphics adjusted.

Navigation must be assigned via NavHostFragment within the related activity.

Take a look at the project files:
<ul>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/res/navigation/navigation_graph.xml">navigation.xml</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/java/com/omercankoc/navigations/MainActivity.kt">MainActivity.kt</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/res/layout/activity_main.xml">activity_main.xml</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/java/com/omercankoc/navigations/FirstFragment.kt">FirstFragment.kt</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/res/layout/fragment_first.xml">fragment_first.xml</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/java/com/omercankoc/navigations/SecondFragment.kt">SecondFragment</a>
  </li>
  <li>
    <a href="https://github.com/omercankoc/navigations/blob/main/Navigations/app/src/main/res/layout/fragment_second.xml">fragment_second.xml</a>
  </li>
</ul>

### Example for transitioning from the FirstFragment to the SecondFragment:
```kotlin
buttonNext.setOnClickListener {
    val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
    Navigation.findNavController(it).navigate(action)
}
```

### Example for transitioning from the SecondFragment to the FirstFragment:
```kotlin
buttonBack.setOnClickListener {
    val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
    Navigation.findNavController(it).navigate(action)
}
```

### Send data Fragment to Fragment:
```kotlin
buttonNext.setOnClickListener {
    val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("androidDeveloper")
    Navigation.findNavController(it).navigate(action)
}
```

### Get data Fragment to Fragment:
```kotlin
arguments?.let {
    val username = SecondFragmentArgs.fromBundle(it).username
    textViewSecond.text = username
}

buttonBack.setOnClickListener {
    val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
    Navigation.findNavController(it).navigate(action)
}
```
