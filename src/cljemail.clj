(ns cljemail
  (:require [postal.core :as postal]
            [environ.core :as environ])
   (:gen-class
   :methods [^:static [handler [String] String]]))

(defn get-body [name]
  (str "Hello, " name "! This is a test."))

(defn send-email [name]
  (postal/send-message {:host "smtp.gmail.com"
                        :user "zstickles@gmail.com"
                        :pass (environ/env :email-pw)
                        :port 587
                        :tls true}
                       {:from "robot@zstix.io"
                        :to "zstickles@gmail.com"
                        :subject "Test email from Clojure via Postal"
                        :body (get-body name)}))

;; Update handler signature (here and above) as needed
(defn -handler [name]
  (send-email name))
