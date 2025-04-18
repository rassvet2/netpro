# netpro

汝、Markdownを愛したまえ。
汝、ついでにGradleを愛したまえ。

## 実行
`-Pmain`に指定することにより、エントリポイントを指定できる。
```sh
./gradlew run -Pmain="tdu_iwai.App"
./gradlew run -Pmain="tdu_iwai.Hello"
./gradlew run -Pmain="tdu_iwai.HelloArgs"
```

`--args`を指定することにより、`main`関数に渡す引数を指定できる。
```sh
./gradlew run -Pmain="tdu_iwai.HelloArgs" --args="a b c"
```

`--console=plain`を指定することにより、標準入力するプログラムを実行しやすくなる。
```sh
./gradlew run --console=plain -Pmain="tdu_iwai.PrintYourAge"
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
