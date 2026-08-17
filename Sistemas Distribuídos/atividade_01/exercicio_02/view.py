class View:
    """
    Classe responsável pela exibição de informações para o usuário final
    """  
    def exibir_valor_total(self, valor):
        """
        Exibe faturamento total anual do sistema.
        Args:
            valor (int):  O valor final é composto pela soma das vendas das 4 filiais
        """ 
        print(f"Faturamento total anual: R${valor}")