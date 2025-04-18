# netpro

汝、Markdownを愛したまえ。

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
