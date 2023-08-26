input("Digite uma palavra: ")
palavra = input()
palavra = palavra.lower()

palavra_invertida = palavra[::-1]
print(palavra_invertida)

if palavra == palavra_invertida:
    print("É um palíndromo")
else:
    print("Não é um palíndromo")
