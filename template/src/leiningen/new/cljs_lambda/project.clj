(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [io.nervous/cljs-lambda "0.2.0"]
                 [io.nervous/cljs-nodejs-externs "0.2.0"]]
  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-npm "0.6.0"]
            [lein-doo "0.1.7-SNAPSHOT"]
            [io.nervous/lein-cljs-lambda "0.5.0-SNAPSHOT"]]
  :npm {:dependencies [[source-map-support "0.2.8"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:defaults {:role "FIXME"}
   :resource-dirs ["static"]
   :functions
   [{:name   "work-magic"
     :invoke {{name}}.core/work-magic}]}
  :cljsbuild
  {:builds [{:id "{{name}}"
             :source-paths ["src"]
             :compiler {:output-to "target/{{name}}/{{sanitized}}.js"
                        :output-dir "target/{{name}}"
                        :target :nodejs
                        :optimizations :advanced}}
            {:id "{{name}}-test"
             :source-paths ["src" "test"]
             :compiler {:output-to "target/{{name}}-test/{{sanitized}}.js"
                        :output-dir "target/{{name}}-test"
                        :target :nodejs
                        :optimizations :none
                        :main {{name}}.test-runner}}]})
