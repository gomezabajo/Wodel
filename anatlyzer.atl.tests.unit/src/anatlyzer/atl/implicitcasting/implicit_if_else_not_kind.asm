<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="implicitifelse"/>
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
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
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
		<constant value="name2"/>
		<constant value="MABCD!Model;"/>
		<constant value="0"/>
		<constant value="elements"/>
		<constant value="B"/>
		<constant value="ABCD"/>
		<constant value="J.oclIsKindOf(J):J"/>
		<constant value="J.not():J"/>
		<constant value="propOfB"/>
		<constant value="it is ok"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.first():J"/>
		<constant value="7:52-7:56"/>
		<constant value="7:52-7:65"/>
		<constant value="8:14-8:15"/>
		<constant value="8:28-8:34"/>
		<constant value="8:14-8:35"/>
		<constant value="8:10-8:35"/>
		<constant value="11:5-11:6"/>
		<constant value="11:5-11:14"/>
		<constant value="9:5-9:15"/>
		<constant value="8:7-12:9"/>
		<constant value="7:52-13:7"/>
		<constant value="7:52-13:16"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="17:10-19:6"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.name2():J"/>
		<constant value="18:14-18:17"/>
		<constant value="18:14-18:25"/>
		<constant value="18:6-18:25"/>
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
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<call arg="51"/>
			<call arg="52"/>
			<if arg="26"/>
			<load arg="19"/>
			<get arg="53"/>
			<goto arg="21"/>
			<push arg="54"/>
			<call arg="55"/>
			<enditerate/>
			<call arg="56"/>
		</code>
		<linenumbertable>
			<lne id="57" begin="3" end="3"/>
			<lne id="58" begin="3" end="4"/>
			<lne id="59" begin="7" end="7"/>
			<lne id="60" begin="8" end="10"/>
			<lne id="61" begin="7" end="11"/>
			<lne id="62" begin="7" end="12"/>
			<lne id="63" begin="14" end="14"/>
			<lne id="64" begin="14" end="15"/>
			<lne id="65" begin="17" end="17"/>
			<lne id="66" begin="7" end="17"/>
			<lne id="67" begin="0" end="19"/>
			<lne id="68" begin="0" end="20"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="6" end="18"/>
			<lve slot="0" name="17" begin="0" end="20"/>
		</localvariabletable>
	</operation>
	<operation name="69">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="70"/>
			<push arg="50"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="74"/>
			<dup/>
			<push arg="75"/>
			<load arg="19"/>
			<pcall arg="76"/>
			<dup/>
			<push arg="77"/>
			<push arg="70"/>
			<push arg="78"/>
			<new/>
			<pcall arg="79"/>
			<pusht/>
			<pcall arg="80"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="81" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="75" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="82">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="75"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="77"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="87"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="88" begin="11" end="11"/>
			<lne id="89" begin="11" end="12"/>
			<lne id="90" begin="9" end="14"/>
			<lne id="81" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="77" begin="7" end="15"/>
			<lve slot="2" name="75" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="91" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
