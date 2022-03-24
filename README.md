# TDD Workshop

## Deafio dia 2

Calcular o valor da taxa de serviço <b>(serviceFeeValue)</b>  e o valor da gorjeta do entregador <b>(driverTipValue)</b> , Onde:

### <b>serviceFeeValue:</b> 
Caso o valor de itemsValue for menor que 20,00, então devemos cobrar uma taxa de serviço, o valor desta taxa de serviço será configurada em um serviço de configuração remota, caso o valor for maior que 20,00, a taxa de serviço será zerada (0,00)

### <b>driverTipValue:</b>
Caso o método de entrega for do tipo retirada (TAKEAWAY) este valor será zerado (0,0), caso contrário, valor que será dado de gorjeta ao entregador, este valor somente será calculado em caso de pagamento online


## Dicas

 - Escreva primeiramente os testes
 - Pense nas possíveis dependências externas
 - Trate as dependencias como abstrações (interfaces)
 - Siga o fluxo "Test -> Red -> Refactor -> Green"
 - Explore os casos limites nos seus testes
 - Um método não tem apenas um teste necessáriamente, um requisito tem um teste obrigatóriamente
 - Rode os testes a todo o momento, a cada alteração que fizer
