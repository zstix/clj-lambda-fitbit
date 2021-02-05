(defproject clj-email "0.1.0"
  :dependencies [[org.clojure/clojure "1.10.2"]
                 [org.clojure/data.json "0.2.6"]
                 [com.amazonaws/aws-lambda-java-core "1.0.0"]
                 [com.draines/postal "2.0.4"]
                 [environ "1.2.0"]
                 [clj-http "3.12.0"]]
  :plugins [[lein-environ "1.2.0"]]
  :java-source-paths ["src/java"]
  :aot :all)
