# {{name}}

FIXME

Based on [referable](https://www.github.com/bobbyno/referable).

## Development

To start a web server for the application, run:

    lein ring server

## Testing

    make all

This target builds an uberjar, starts it, then verifies that the top-level endpoint responds with a 200.

## Docker

    make docker-build
    make docker-run
    make test-docker
