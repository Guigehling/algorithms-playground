# Fenwick Tree (Binary Indexed Tree)

Este documento resume os principais conceitos aprendidos sobre **Fenwick Tree (BIT)**, com foco em intuição, LSB e aplicações práticas.

---

## Conceito Básico

A Fenwick Tree é uma estrutura de dados usada para:

- Atualizações pontuais em um array
- Consultas de soma prefixada (1 até i)

Ambas as operações são feitas em **O(log n)**.

---

## O papel do LSB (Least Significant Bit)

O funcionamento da BIT é totalmente baseado em:

```
LSB(i) = i & (-i)
```

O LSB define o **tamanho do bloco** que cada índice representa dentro da árvore.

### Como ler isso intuitivamente (REGRA FUNDAMENTAL)

- **Números ímpares** → LSB = **1**
- **Potências de 2** (2, 4, 8, …) → LSB = **o próprio número**
- **Outros pares** → LSB = **menor potência de 2 contida neles**

Essa regra explica todo o comportamento da Fenwick Tree.

---

## LSB de 1 a 7 (exemplo)

| Índice | Binário | LSB |
|------|--------|-----|
| 1 | 001 | 1 |
| 2 | 010 | 2 |
| 3 | 011 | 1 |
| 4 | 100 | 4 |
| 5 | 101 | 1 |
| 6 | 110 | 2 |
| 7 | 111 | 1 |

---

## O que cada BIT[i] representa

Cada posição da Fenwick Tree cobre o intervalo:

```
[i - LSB(i) + 1 .. i]
```

Exemplo:

| i | LSB | Intervalo coberto |
|--|----|------------------|
| 3 | 1 | [3..3] |
| 4 | 4 | [1..4] |
| 6 | 2 | [5..6] |

---

## Visualização como árvore binária (intuitiva)

A Fenwick Tree não é uma árvore tradicional, mas **pode ser visualizada assim**:

```
         [8]
         /
        [4]          
      /     \
     [2]     [6]
    /   \    / \
  [1]   [3] [5] [7]
```

- Cada nó agrupa a soma de seus filhos
- Subir na árvore significa **intervalos maiores**
- Andar para baixo significa **blocos menores**

---

## Regras operacionais importantes

### Soma prefixada (query)

Sempre anda **para trás**:

```
i -= LSB(i)
```

### Atualização (update)

Sempre anda **para frente**:

```
i += LSB(i)
```

Não há decisões condicionais — o caminho é 100% matemático.

---

## Principais casos de uso (bem breve)

- Métricas acumuladas em tempo real
- Rankings dinâmicos (leaderboards)
- Séries temporais discretas
- Contadores de frequência
- Eventos, cliques, acessos

---

## Regra mental final

> **Se o problema envolve atualizações frequentes e somas acumuladas rápidas, Fenwick Tree é uma excelente escolha.**
