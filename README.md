# Shopping List Android

An Android client for the [Shopping List](https://github.com/hidakatsuya/shopping_list) web app.
It is built with [turbo-android](https://github.com/hotwired/turbo-android).

## Status

Under development

## Development

1. Create Google OAuth client
2. Create `debug.properties` file
3. Set build configs
  ```
  BASE_URL=<base url of your web app>
  GOOGLE_CLIENT_ID=<your client id>
  ```

## Release

1. Create Google OAuth client
2. Create `release.properties` file
3. Set build configs
  ```
  BASE_URL=<base url of your web app>
  GOOGLE_CLIENT_ID=<your client id>
  ```
4. Setup [App signing](https://developer.android.com/studio/publish/app-signing)
5. Create `app/signingConfigs/release.gradle` and move `signingConfigs` added to `build.gradle`
