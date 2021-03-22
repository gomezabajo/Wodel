#!/usr/bin/python3

import ast

from collections import defaultdict
from random import shuffle

# Be careful about modifications...

#TODO the hard part -- prove correctness or find that one bug

def printdfa(dfa):
    for key,val in dfa.items():
        print(key, val)
        
def makeClauses(dfa):
    clauses = {}
    for key, (_, links) in dfa.items():
        nli = defaultdict(set)
        terms = set()
        for char, target in links.items():
            if dfa[target][0]:
                terms.add(char)
            nli[target].add(char)
        clauses[key] = (terms, nli)
    return clauses

def rjoin(inx):
    # problem: resolving common prefixes requires stack action
    return "(" + "+".join(inx) + ")"

def applyArden(clauses):
    nc = dict()
    for key, (terms, links) in clauses.items():
        if key in links:
            inits = links.pop(key)
            pref = rjoin(inits)+"*"
            terms = set(pref + t  for t in terms)
            for k, keyset in links.items():
                keyset2 = set(pref + t for t in keyset)
                links[k] = keyset
        nc[key] = (terms, links)
    return nc

def reduceClauses(clauses, target):
    subst = clauses.pop(target)
    for key, (terms, links) in clauses.items():
        if target in links:
            splitset = links.pop(target)
            # cartesian prefix splitset for everything in subst
            for prefix in splitset:
                fins, crosses = subst
                for symb in fins:
                    terms.add(prefix + symb)
                for cross, postfixes in crosses.items():
                    iset = links[cross]
                    for postfix in postfixes:
                        iset.add(prefix + postfix)
    return clauses

def flatten(clauses, entry):
    x = [k for k in clauses.keys() if k != entry]
    shuffle(x)
    clauses = applyArden(clauses)
    for k in x:
        clauses = reduceClauses(clauses, k)
        clauses = applyArden(clauses)
    finx = clauses[entry]
    assert(len(finx[1]) == 0)
    return rjoin(finx[0])

# printdfa(dfa1)
# x = makeClauses(dfa1)

# x = flatten(x,1)
# print(x)

def getRegEx(text):
  dict = ast.literal_eval(text)
  x = makeClauses(dict)
  return flatten(x, 1)