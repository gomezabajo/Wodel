from bits import desplazar_izquierda, desplazar_derecha, or_bits, xor_bits, and_bits

def test_desplazar_izquierda():
    assert desplazar_izquierda(4, 1) == 8
    assert desplazar_izquierda(1, 3) == 8
    assert desplazar_izquierda(3, 2) == 12
    assert desplazar_izquierda(7, 2) == 28

def test_desplazar_derecha():
    assert desplazar_derecha(8, 1) == 4
    assert desplazar_derecha(16, 3) == 2
    assert desplazar_derecha(12, 2) == 3
    assert desplazar_derecha(28, 2) == 7

def test_or_bits():
    assert or_bits(5, 3) == 7
    assert or_bits(12, 10) == 14
    assert or_bits(0, 0) == 0
    assert or_bits(6, 3) == 7

def test_xor_bits():
    assert xor_bits(5, 3) == 6
    assert xor_bits(12, 10) == 6
    assert xor_bits(0, 0) == 0
    assert xor_bits(7, 5) == 2

def test_and_bits():
    assert and_bits(5, 3) == 1
    assert and_bits(12, 10) == 8
    assert and_bits(0, 0) == 0
    assert and_bits(7, 5) == 5
