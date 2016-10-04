# {{name}}

FIXME

Based on [referable](https://www.github.com/bobbyno/referable).

## Development

To start a web server for the application, run:

    lein ring server

## Running as an Uberjar

    lein uberjar
    make run

The port defaults to 8080.

## Smoke Testing

After the server is started, ensure it's responsive with `make smoketest` or
`PORT=xxxx make smoketest` if you customized the port.
