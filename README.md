# JMovie - TMDB Remote Data Structure

This project now includes a standard remote data architecture for TMDB API (`https://api.themoviedb.org/3/`) using:
- Retrofit + OkHttp
- Kotlin Coroutines
- Hilt Dependency Injection
- Repository + UseCase + UI state pattern

## Package Structure

- `app/src/main/java/com/example/jmovie/data/remote/api` - Retrofit service interfaces
- `app/src/main/java/com/example/jmovie/data/remote/dto` - DTO models from API
- `app/src/main/java/com/example/jmovie/data/remote/interceptor` - request/auth interceptor
- `app/src/main/java/com/example/jmovie/data/repository` - Repository implementations
- `app/src/main/java/com/example/jmovie/data/di` - Hilt modules
- `app/src/main/java/com/example/jmovie/domain` - Domain models, repository contracts, use cases
- `app/src/main/java/com/example/jmovie/ui` - ViewModel and Compose screen state

## Setup

1. Add your TMDB v4 read access token to `local.properties`:

```properties
TMDB_BEARER_TOKEN=your_tmdb_v4_read_access_token
```

2. Sync Gradle.

3. Run unit tests:

```bash
./gradlew test
```

4. Run app:

```bash
./gradlew installDebug
```

