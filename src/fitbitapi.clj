(ns fitbitapi
  (:require [clj-http.client :as client]
            [environ.core :as environ])
  (:import java.util.Base64))

(defn get-auth []
  "Base64 encoded string `client_id:client_secret`"
  (.encodeToString
   (Base64/getEncoder)
   (.getBytes (str (environ/env :fitbit-client-id) ":"
                   (environ/env :fitbit-client-secret)))))
                                                      
(defn get-token []
  (client/post "https://api.fitbit.com/oauth2/token"
              {:basic-auth (get-auth)
               :form-params {:code ""
                             :grant_type ""}
               :async? true}
              (fn [resp] (println "response: " resp))
              (fn [exception] (println "exception: " (.getMessage exception)))))
