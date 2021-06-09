(ns user-registration.services.pages)

(defn get-pages [country-code]
  {:pages [{:children [{:type "Header"
                        :title "Boas-vindas ao Nubank! Para começar qual o seu CPF?"
                        :subtitle "Precisamos dele para dar inicio ao seu cadastro"}
                       {:type "Input"
                        :keyboard "number"
                        :id "document"}]
            :bottom {:type "BottomButton"
                     :text "Continuar"}}
           {:children [{:type "Header"
                        :title "Agora precisamos do seu nome"}
                       {:type "Input"
                        :keyboard "string"
                        :id "name"}]
            :bottom  {:type "BottomButton"
                      :text "Continuar"}}
           {:children [{:type "Header"
                        :title "Certo agora precisamos do seu email"
                        :subtitle "Utilizamos o email para validar os dados"}
                       {:type "Input"
                        :keyboard "string"
                        :id "email"}]
            :bottom {:type "BottomButton"
                     :text "Continuar"}}
           {:children [{:type "Header"
                        :title "Agora preciso da sua data de nascimento"}
                       {:type "Input"
                        :keyboard "string"
                        :id "birthday"}]
            :bottom  {:type "BottomButton"
                      :text "Continuar"
                      :action {:method "post"
                               :uri "/submit"}}}]})