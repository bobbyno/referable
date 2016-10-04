(ns leiningen.new.referable
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             project-name sanitize-ns]]))

(defn referable
  "A referable api project template."
  [name & args]
  (let [render (renderer "referable")
        main-ns (sanitize-ns name)
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :sanitized (name-to-path main-ns)}]
    (println (str "Generated a referable api project called " name "."))
    (->files data
             [".env" (render ".env" data)]
             [".gitignore" (render ".gitignore" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["Dockerfile.m4" (render "Dockerfile.m4" data)]
             ["README.md" (render "README.md" data)]
             ["src/{{sanitized}}/api.clj" (render "api.clj" data)]
             ["test/{{sanitized}}/api_test.clj" (render "api_test.clj" data)]
             ["src/{{sanitized}}/build.clj" (render "build.clj" data)]
             ["build/docker.makefile" (render "docker.makefile" data)]
             ["build/http.makefile" (render "http.makefile" data)]
             ["resources/logback.xml" (render "logback.xml" data)]
             ["makefile" (render "makefile" data)]
             ["project.clj" (render "project.clj" data)]
             ["resources/stdout.xml" (render "stdout.xml" data)]
             ["src/{{sanitized}}/system.clj" (render "system.clj" data)])))
