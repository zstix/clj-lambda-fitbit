(ns fitbitapi
  (:require [clj-http.client :as client]
            [environ.core :as environ])
  (:import java.util.Base64))

(defn get-auth []
  (.encodeToString
   (Base64/getEncoder)
   (.getBytes (str (environ/env :fitbit-client-id) ":"
                   (environ/env :fitbit-client-secret)))))
                                                      
(defn get-token []
  (client/get "https://api.fitbit.com/oauth2/token"
              {:basic-auth (get-auth)
               ;; TODO: remaining part of request
               }))
