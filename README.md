# Referable lein-template

Generate a new referable API project. Referable is a simple reference for RESTful API's in Clojure.

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

