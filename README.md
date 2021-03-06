# Referable
### A lein template for a RESTful API in Clojure

Generates a new RESTful API project ready for deployment as an uberjar or a Docker container.

## Usage

To generate a new project: `lein new referable my-name`. You will have a new API in the directory `my-name`.

Read the [README in your generated api](./src/leiningen/new/referable/README.md) for more information.


## Development

There are two ways to try out local changes to this template:

1. Run `lein new referable NAME` in this directory.

2. `lein install` in this directory;

   Add `referable/lein-template` to the `:plugins` vector of your `:user` profile in `~/.lein/profiles.clj`;
   ```clojure
   {:user {:plugins [[referable/lein-template "0.1.0-SNAPSHOT"]]}}
   ```

   Generate a new project.


## Testing

To generate a project and run a set of smoke tests on it, use the default `make` target.

Simply run `make`.
