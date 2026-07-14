<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="featurefoundinallsubtypes"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="B"/>
		<constant value="ABCD"/>
		<constant value="propOfC"/>
		<constant value="__initpropOfC"/>
		<constant value="J.registerHelperAttribute(SS):V"/>
		<constant value="D"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="10:16-10:22"/>
		<constant value="13:16-13:22"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchmodel():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="MABCD!B;"/>
		<constant value="imitatingPropOfC"/>
		<constant value="11:2-11:20"/>
		<constant value="MABCD!D;"/>
		<constant value="14:2-14:20"/>
		<constant value="__matchmodel"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="X"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="18:10-20:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="19:14-19:17"/>
		<constant value="19:14-19:25"/>
		<constant value="19:6-19:25"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<push arg="14"/>
			<push arg="15"/>
			<findme/>
			<push arg="16"/>
			<push arg="17"/>
			<pcall arg="18"/>
			<push arg="19"/>
			<push arg="15"/>
			<findme/>
			<push arg="16"/>
			<push arg="17"/>
			<pcall arg="18"/>
			<getasm/>
			<push arg="20"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="21"/>
			<getasm/>
			<pcall arg="22"/>
		</code>
		<linenumbertable>
			<lne id="23" begin="16" end="18"/>
			<lne id="24" begin="22" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="36"/>
		</localvariabletable>
	</operation>
	<operation name="26">
		<context type="6"/>
		<parameters>
			<parameter name="27" type="4"/>
		</parameters>
		<code>
			<load arg="27"/>
			<getasm/>
			<get arg="3"/>
			<call arg="28"/>
			<if arg="29"/>
			<getasm/>
			<get arg="1"/>
			<load arg="27"/>
			<call arg="30"/>
			<dup/>
			<call arg="31"/>
			<if arg="32"/>
			<load arg="27"/>
			<call arg="33"/>
			<goto arg="34"/>
			<pop/>
			<load arg="27"/>
			<goto arg="35"/>
			<push arg="36"/>
			<push arg="8"/>
			<new/>
			<load arg="27"/>
			<iterate/>
			<store arg="37"/>
			<getasm/>
			<load arg="37"/>
			<call arg="38"/>
			<call arg="39"/>
			<enditerate/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="41" begin="23" end="27"/>
			<lve slot="0" name="25" begin="0" end="29"/>
			<lve slot="1" name="42" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
			<parameter name="27" type="4"/>
			<parameter name="37" type="44"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="27"/>
			<call arg="30"/>
			<load arg="27"/>
			<load arg="37"/>
			<call arg="45"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="6"/>
			<lve slot="1" name="42" begin="0" end="6"/>
			<lve slot="2" name="46" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="47">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="48"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="49">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<call arg="51"/>
			<iterate/>
			<store arg="27"/>
			<getasm/>
			<load arg="27"/>
			<pcall arg="52"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="41" begin="5" end="8"/>
			<lve slot="0" name="25" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="17">
		<context type="53"/>
		<parameters>
		</parameters>
		<code>
			<push arg="54"/>
		</code>
		<linenumbertable>
			<lne id="55" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="17">
		<context type="56"/>
		<parameters>
		</parameters>
		<code>
			<push arg="54"/>
		</code>
		<linenumbertable>
			<lne id="57" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="25" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="58">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="15"/>
			<findme/>
			<push arg="59"/>
			<call arg="60"/>
			<iterate/>
			<store arg="27"/>
			<getasm/>
			<get arg="1"/>
			<push arg="61"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="50"/>
			<pcall arg="62"/>
			<dup/>
			<push arg="63"/>
			<load arg="27"/>
			<pcall arg="64"/>
			<dup/>
			<push arg="65"/>
			<push arg="66"/>
			<push arg="67"/>
			<new/>
			<pcall arg="68"/>
			<pusht/>
			<pcall arg="69"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="70" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="63" begin="6" end="26"/>
			<lve slot="0" name="25" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="71">
		<context type="6"/>
		<parameters>
			<parameter name="27" type="72"/>
		</parameters>
		<code>
			<load arg="27"/>
			<push arg="63"/>
			<call arg="73"/>
			<store arg="37"/>
			<load arg="27"/>
			<push arg="65"/>
			<call arg="74"/>
			<store arg="75"/>
			<load arg="75"/>
			<dup/>
			<getasm/>
			<load arg="37"/>
			<get arg="16"/>
			<call arg="38"/>
			<set arg="46"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="76" begin="11" end="11"/>
			<lne id="77" begin="11" end="12"/>
			<lne id="78" begin="9" end="14"/>
			<lne id="70" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="65" begin="7" end="15"/>
			<lve slot="2" name="63" begin="3" end="15"/>
			<lve slot="0" name="25" begin="0" end="15"/>
			<lve slot="1" name="79" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
