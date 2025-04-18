# netpro

汝、Markdownを愛したまえ。
汝、ついでにGradleを愛したまえ。

## 実行
`-Pmain`に指定することにより、エントリポイントを指定できる。
```sh
./gradlew run -Pmain="App"
./gradlew run -Pmain="Hello"
./gradlew run -Pmain="HelloArgs"
```

`--args`を指定することにより、`main`関数に渡す引数を指定できる。
```sh
./gradlew run -Pmain="HelloArgs" --args="a b c"
```

`--console=plain`を指定することにより、標準入力するプログラムを実行しやすくなる。
```sh
./gradlew run --console=plain -Pmain="PrintYourAge"
```

## 文字コードについて

`build.gradle.kts`に以下を記述
```kts
application {
    applicationDefaultJvmArgs = listOf("-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8" // 不要かも
}
```

`gradlew(\.bat)?`に以下を記述
```sh
JAVA_OPTS="$JAVA_OPTS '-Dfile.encoding=UTF-8'"
```

```bat
set JAVA_OPTS=%JAVA_OPTS% "-Dfile.encoding=UTF-8"
```
