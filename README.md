# TDD Workshop

## Deafio dia 2

Calcular o valor da taxa de serviço <b>(serviceFeeValue)</b>  e o valor da gorjeta do entregador <b>(driverTipValue)</b> , Onde:

### <b>serviceFeeValue:</b> 
Caso o valor de itemsValue for menor que 20,00, então devemos cobrar uma taxa de serviço, o valor desta taxa de serviço será configurada em um serviço de configuração remota, caso o valor for maior que 20,00, a taxa de serviço será zerada (0,00)

### <b>driverTipValue:</b>
Caso o método de entrega for do tipo retirada (TAKEAWAY) este valor será zerado (0,0), caso contrário, valor que será dado de gorjeta ao entregador, este valor somente será calculado em caso de pagamento online
