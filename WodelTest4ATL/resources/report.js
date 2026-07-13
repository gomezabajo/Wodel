const sampleData = window.WodelTestReportData || {};

    let reportData = null;
    let currentSuiteIndex = 0;
    let currentView = 'global';

    const app = document.getElementById('app');
    const metaLine = document.getElementById('metaLine');
    const jsonInput = document.getElementById('jsonInput');
    const loadBtn = document.getElementById('loadBtn');
    const sampleBtn = document.getElementById('sampleBtn');
    const fileInput = document.getElementById('fileInput');
    const fileBtn = document.getElementById('fileBtn');

    function escapeHtml(value) {
      return String(value ?? '')
        .replaceAll('&', '&amp;')
        .replaceAll('<', '&lt;')
        .replaceAll('>', '&gt;')
        .replaceAll('"', '&quot;')
        .replaceAll("'", '&#39;');
    }

    function pct(value) {
      return `${(Number(value || 0) * 100).toFixed(2).replace(/\.00$/, '')}%`;
    }

    function formatNumber(value) {
      return Number(value || 0).toLocaleString();
    }

    function normalizeArray(value) {
      return Array.isArray(value) ? value : [];
    }

    function classStatus(mutant) {
      if ((mutant.failedTests || 0) > 0) return 'green';
      if ((mutant.numFailures || 0) > 0) return 'grey';
      return 'red';
    }

    function classTestStatus(result) {
      if (result.failure) return 'grey';
      return result.value ? 'green' : 'red';
    }

    function mutatorStatus(item) {
      if ((item.failures || 0) > 0) return 'grey';
      return (item.numberOfMutants || 0) > 0 ? 'green' : 'red';
    }

    function mutatorGroupStatus(group) {
      const operators = normalizeArray(group.operators);
      if (operators.some(op => (op.numberOfMutants || 0) > 0)) return 'green';
      if (operators.some(op => (op.failures || 0) > 0)) return 'grey';
      return 'red';
    }

    function testStatus(test) {
      if ((test.failures || 0) > 0) return 'grey';
      return (test.detectedMutants || 0) > 0 ? 'green' : 'red';
    }

    function testSuiteStatus(entry) {
      const results = normalizeArray(entry.results);
      if ((entry.killedMutants || 0) > 0) return 'green';
      if (results.some(r => (r.failures || 0) > 0)) return 'grey';
      return 'red';
    }

    function renderBadges(items, color) {
      const arr = normalizeArray(items);
      if (!arr.length) return '<span class="muted">None</span>';
      return arr.map(item => `<span class="pill ${color}">${escapeHtml(item)}</span>`).join(' ');
    }

    function renderListPanel(title, items, color) {
      return `
        <div class="summary-box">
          <h3>${escapeHtml(title)}</h3>
          <div>${renderBadges(items, color)}</div>
        </div>
      `;
    }

    function renderProgress(title, leftLabel, leftValue, middleLabel, middleValue, rightLabel, rightValue, total, colors) {
      const safeTotal = Math.max(Number(total || 0), 1);
      const leftPct = (Number(leftValue || 0) / safeTotal) * 100;
      const middlePct = (Number(middleValue || 0) / safeTotal) * 100;
      const rightPct = Math.max(0, 100 - leftPct - middlePct);
      return `
        <div class="summary-box">
          <h3>${escapeHtml(title)}</h3>
          <div class="progress-wrap">
            <div class="progress-head">
              <span>${escapeHtml(leftLabel)}: <strong>${formatNumber(leftValue)}</strong></span>
              ${middleLabel ? `<span>${escapeHtml(middleLabel)}: <strong>${formatNumber(middleValue)}</strong></span>` : ''}
              <span>${escapeHtml(rightLabel)}: <strong>${formatNumber(rightValue)}</strong></span>
            </div>
            <div class="progress">
              <div class="seg ${colors[0]}" style="width:${leftPct}%"></div>
              ${middleLabel ? `<div class="seg ${colors[1]}" style="width:${middlePct}%"></div>` : ''}
              <div class="seg ${middleLabel ? colors[2] : colors[1]}" style="width:${rightPct}%"></div>
            </div>
            <div class="legend">
              <span><span class="dot" style="background:${cssColor(colors[0])}"></span>${escapeHtml(leftLabel)}</span>
              ${middleLabel ? `<span><span class="dot" style="background:${cssColor(colors[1])}"></span>${escapeHtml(middleLabel)}</span>` : ''}
              <span><span class="dot" style="background:${cssColor(middleLabel ? colors[2] : colors[1])}"></span>${escapeHtml(rightLabel)}</span>
            </div>
          </div>
        </div>
      `;
    }

    function cssColor(token) {
      const map = {
        green: 'var(--green)',
        red: 'var(--red)',
        grey: 'var(--grey)',
        orange: 'var(--orange)',
        blue: 'var(--blue)'
      };
      return map[token] || token;
    }

    function renderGlobalView(suite) {
      const g = suite.global || {};
      const testsExecutionTime = g.testsExecutionTimeSeconds ?? ((g.runningTimeSeconds || 0) - (g.mutationTimeSeconds || 0));
      return `
        <div class="summary-box">
          <h3>${escapeHtml(suite.name)} overview</h3>
          <p>
            #Generated mutants: <strong>${formatNumber(g.generatedMutants)}</strong>
            — Mutation score: <strong>${pct(g.mutationScore)}</strong>
            — Total running time: <strong>${formatNumber(g.runningTimeSeconds)} s</strong>
            — Mutation time: <strong>${formatNumber(g.mutationTimeSeconds)} s</strong>
            — Tests execution time: <strong>${formatNumber(testsExecutionTime)} s</strong>
          </p>
        </div>
        ${normalizeArray(reportData.notes).length ? `
        <div class="panel" style="margin-bottom:14px;">
          <div class="section-title"><h2>Notes</h2></div>
          <div class="tree-body">
            <ul style="margin:0; padding-left:20px; color: var(--muted);">
              ${normalizeArray(reportData.notes).map(note => `<li>${escapeHtml(note)}</li>`).join('')}
            </ul>
          </div>
        </div>` : ''}
        <div class="grid-4">
          ${metricCard('Generated mutants', g.generatedMutants)}
          ${metricCard('Mutation score', pct(g.mutationScore))}
          ${metricCard('Tests executed', g.testsExecuted)}
          ${metricCard('Mutants compiling', g.mutantsCompiling)}
        </div>
        <div class="grid-3" style="margin-top:14px;">
          ${renderProgress('Mutation operators applied/selected', 'Applied', g.operatorsApplied, '', 0, 'Not applied', Math.max(0, (g.operatorsSelected || 0) - (g.operatorsApplied || 0)), g.operatorsSelected || 0, ['green', 'red'])}
          ${renderProgress('Mutants killed/equivalent/live', 'Killed', g.mutantsKilled, 'Equivalent', g.mutantsEquivalent, 'Live', g.mutantsLive, Math.max(1, (g.mutantsKilled || 0) + (g.mutantsEquivalent || 0) + (g.mutantsLive || 0)), ['green', 'orange', 'red'])}
          ${renderProgress('Tests failed/passed/error', 'Failed', g.testsFailed, 'Passed', g.testsPassed, 'Error', g.testsError, Math.max(1, (g.testsFailed || 0) + (g.testsPassed || 0) + (g.testsError || 0)), ['green', 'red', 'blue'])}
        </div>
        <div class="grid-2" style="margin-top:14px;">
          ${renderListPanel('Applied mutators', g.appliedMutators, 'green')}
          ${renderListPanel('Selected but not applied mutators', g.notAppliedMutators, 'red')}
          ${renderListPanel('Killed mutants', g.killedClasses, 'green')}
          ${renderListPanel('Equivalent mutants', g.equivalentClasses, 'orange')}
          ${renderListPanel('Live mutants', g.liveClasses, 'red')}
          ${renderListPanel('Failed tests', g.failedTests, 'green')}
          ${renderListPanel('Passed tests', g.passedTests, 'red')}
          ${renderListPanel('Error tests', g.errorTests, 'blue')}
        </div>
      `;
    }

    function metricCard(label, value, sub = '') {
      return `
        <div class="card">
          <div class="label">${escapeHtml(label)}</div>
          <div class="value">${escapeHtml(value)}</div>
          ${sub ? `<div class="sub">${escapeHtml(sub)}</div>` : ''}
        </div>
      `;
    }

    function aggregateClassPackage(pkg) {
      let executed = 0, failed = 0, hasDetected = false, hasError = false;
      normalizeArray(pkg.classes).forEach(cls => {
        normalizeArray(cls.mutants).forEach(mutant => {
          executed += Number(mutant.executedTests || 0);
          failed += Number(mutant.failedTests || 0);
          if ((mutant.failedTests || 0) > 0) hasDetected = true;
          if ((mutant.numFailures || 0) > 0) hasError = true;
        });
      });
      return { executed, failed, passed: Math.max(0, executed - failed), status: hasDetected ? 'green' : (hasError ? 'grey' : 'red') };
    }

    function aggregateClass(cls) {
      let executed = 0, failed = 0, hasDetected = false, hasError = false;
      normalizeArray(cls.mutants).forEach(mutant => {
        executed += Number(mutant.executedTests || 0);
        failed += Number(mutant.failedTests || 0);
        if ((mutant.failedTests || 0) > 0) hasDetected = true;
        if ((mutant.numFailures || 0) > 0) hasError = true;
      });
      return { executed, failed, passed: Math.max(0, executed - failed), status: hasDetected ? 'green' : (hasError ? 'grey' : 'red') };
    }

    function matchesClassFilter(mutant, filter) {
      if (filter === 'All') return true;
      if (filter === 'Failed') return (mutant.failedTests || 0) > 0;
      if (filter === 'Passed') return (mutant.failedTests || 0) === 0 && (mutant.numFailures || 0) === 0;
      if (filter === 'Error') return (mutant.numFailures || 0) > 0;
      return true;
    }

    function renderClassView(suite) {
      const packages = normalizeArray(suite.classResults);
      return `
        <div class="panel">
          <div class="section-title">
            <h2>Class Results</h2>
            <div class="actions">
              <label class="muted">Filter
                <select id="classFilter">
                  <option>All</option>
                  <option>Failed</option>
                  <option>Passed</option>
                  <option>Error</option>
                </select>
              </label>
            </div>
          </div>
          <div id="classViewBody"></div>
        </div>
      `;
    }

    function paintClassView(suite) {
      const body = document.getElementById('classViewBody');
      const filter = document.getElementById('classFilter').value;
      const blocks = normalizeArray(suite.classResults).map(pkg => {
        const filteredClasses = normalizeArray(pkg.classes).map(cls => {
          const mutants = normalizeArray(cls.mutants).filter(mutant => matchesClassFilter(mutant, filter));
          return { ...cls, mutants };
        }).filter(cls => cls.mutants.length);
        if (!filteredClasses.length) return '';
        const summary = aggregateClassPackage({ ...pkg, classes: filteredClasses });
        return `
          <details class="tree-card" open>
            <summary>
              <div>
                <strong>${escapeHtml(pkg.packageName)}</strong>
                <div class="muted">Package</div>
              </div>
              <div class="actions">
                <span class="badge ${summary.status}">${summary.status.toUpperCase()}</span>
                <span class="muted">Executed: ${formatNumber(summary.executed)} · Failed: ${formatNumber(summary.failed)} · Passed: ${formatNumber(summary.passed)}</span>
              </div>
            </summary>
            <div class="tree-body">
              ${filteredClasses.map(cls => {
                const clsSummary = aggregateClass(cls);
                return `
                  <details class="tree-card" open>
                    <summary>
                      <div>
                        <strong>${escapeHtml(cls.className)}</strong>
                        <div class="muted">Class</div>
                      </div>
                      <div class="actions">
                        <span class="badge ${clsSummary.status}">${clsSummary.status.toUpperCase()}</span>
                        <span class="muted">Executed: ${formatNumber(clsSummary.executed)} · Failed: ${formatNumber(clsSummary.failed)} · Passed: ${formatNumber(clsSummary.passed)}</span>
                      </div>
                    </summary>
                    <div class="tree-body">
                      ${normalizeArray(cls.mutants).map(mutant => `
                        <details class="tree-card" open>
                          <summary>
                            <div>
                              <strong class="mono">${escapeHtml(mutant.path)}</strong>
                              <div class="muted">Mutant${mutant.equivalent ? ' · marked equivalent' : ''}</div>
                            </div>
                            <div class="actions">
                              ${mutant.equivalent ? '<span class="badge orange">EQUIVALENT</span>' : ''}
                              <span class="badge ${classStatus(mutant)}">${classStatus(mutant).toUpperCase()}</span>
                              <span class="muted">Executed: ${formatNumber(mutant.executedTests)} · Failed: ${formatNumber(mutant.failedTests)} · Passed: ${formatNumber(mutant.passedTests)}</span>
                            </div>
                          </summary>
                          <div class="tree-body">
                            <table>
                              <thead>
                                <tr>
                                  <th>Equivalent</th>
                                  <th>Package/class/mutant</th>
                                  <th>#Executed tests</th>
                                  <th>#Failed tests</th>
                                  <th>#Passed tests</th>
                                  <th>Applied mutations/Failed test message</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr class="status-row-${classStatus(mutant)}">
                                  <td>${mutant.equivalent ? 'Yes' : ''}</td>
                                  <td class="mono">${escapeHtml(mutant.path)}</td>
                                  <td>${formatNumber(mutant.executedTests)}</td>
                                  <td>${formatNumber(mutant.failedTests)}</td>
                                  <td>${formatNumber(mutant.passedTests)}</td>
                                  <td>${escapeHtml(normalizeArray(mutant.mutationText).join('; '))}</td>
                                </tr>
                                ${normalizeArray(mutant.tests).map(test => `
                                  <tr class="status-row-${classTestStatus(test)}">
                                    <td></td>
                                    <td class="mono">${escapeHtml(test.name)}</td>
                                    <td>${formatNumber(test.numExecutions)}</td>
                                    <td>${test.value ? formatNumber(test.numFailed) : ''}</td>
                                    <td>${!test.value ? formatNumber((test.numExecutions || 0) - (test.numFailed || 0)) : ''}</td>
                                    <td>${escapeHtml(test.message || '')}</td>
                                  </tr>
                                `).join('')}
                              </tbody>
                            </table>
                          </div>
                        </details>
                      `).join('')}
                    </div>
                  </details>
                `;
              }).join('')}
            </div>
          </details>
        `;
      }).filter(Boolean).join('');
      body.innerHTML = blocks || '<div class="muted">No class results match the selected filter.</div>';
    }

    function matchesMutatorFilter(item, filter) {
      if (filter === 'All') return true;
      if (filter === 'Applied') return (item.numberOfMutants || 0) > 0;
      if (filter === 'Not applied') return (item.numberOfMutants || 0) === 0 && (item.failures || 0) === 0;
      if (filter === 'Error') return (item.failures || 0) > 0;
      return true;
    }

    function renderMutatorView() {
      return `
        <div class="panel">
          <div class="section-title">
            <h2>Mutator Results</h2>
            <div class="actions">
              <label class="muted">Filter
                <select id="mutatorFilter">
                  <option>All</option>
                  <option>Applied</option>
                  <option>Not applied</option>
                  <option>Error</option>
                </select>
              </label>
            </div>
          </div>
          <div id="mutatorViewBody"></div>
        </div>
      `;
    }

    function paintMutatorView(suite) {
      const body = document.getElementById('mutatorViewBody');
      const filter = document.getElementById('mutatorFilter').value;
      const blocks = normalizeArray(suite.mutatorResults).map(group => {
        const operators = normalizeArray(group.operators).filter(op => matchesMutatorFilter(op, filter));
        if (!operators.length) return '';
        const groupStatus = mutatorGroupStatus({ ...group, operators });
        const total = operators.reduce((sum, op) => sum + Number(op.numberOfMutants || 0), 0);
        return `
          <details class="tree-card" open>
            <summary>
              <div>
                <strong>${escapeHtml(group.groupName)}</strong>
                <div class="muted">${escapeHtml(group.groupDescription || '')}</div>
              </div>
              <div class="actions">
                <span class="badge ${groupStatus}">${groupStatus.toUpperCase()}</span>
                <span class="muted">Generated mutants: ${formatNumber(total)}</span>
              </div>
            </summary>
            <div class="tree-body">
              <table>
                <thead>
                  <tr>
                    <th></th>
                    <th>Mutation operator/description</th>
                    <th>Generated mutants/paths</th>
                  </tr>
                </thead>
                <tbody>
                  ${operators.map(op => `
                    <tr class="status-row-${mutatorStatus(op)}">
                      <td><span class="badge ${mutatorStatus(op)}">${mutatorStatus(op).toUpperCase()}</span></td>
                      <td>${escapeHtml(op.name)}${op.description ? ` / ${escapeHtml(op.description)}` : ''}</td>
                      <td>
                        <div>${formatNumber(op.numberOfMutants)}</div>
                        ${normalizeArray(op.paths).length ? `<div class="muted mono" style="margin-top:6px;">${normalizeArray(op.paths).map(escapeHtml).join('<br>')}</div>` : ''}
                      </td>
                    </tr>
                  `).join('')}
                </tbody>
              </table>
            </div>
          </details>
        `;
      }).filter(Boolean).join('');
      body.innerHTML = blocks || '<div class="muted">No mutator results match the selected filter.</div>';
    }

    function matchesTestFilter(result, filter) {
      if (filter === 'All') return true;
      if (filter === 'Killed') {
        return (result.failures || 0) === 0 && normalizeArray(result.mutants).some(m => m.value === true && m.failure === false);
      }
      if (filter === 'Alive') {
        return (result.failures || 0) === 0 && normalizeArray(result.mutants).some(m => m.value === false && m.failure === false);
      }
      if (filter === 'Error') {
        return (result.failures || 0) > 0;
      }
      return true;
    }

    function renderTestView() {
      return `
        <div class="panel">
          <div class="section-title">
            <h2>Test Results</h2>
            <div class="actions">
              <label class="muted">Filter
                <select id="testFilter">
                  <option>All</option>
                  <option>Killed</option>
                  <option>Alive</option>
                  <option>Error</option>
                </select>
              </label>
            </div>
          </div>
          <div id="testViewBody"></div>
        </div>
      `;
    }

    function paintTestView(suite) {
      const body = document.getElementById('testViewBody');
      const filter = document.getElementById('testFilter').value;
      const blocks = normalizeArray(suite.testResults).map(testSuiteEntry => {
        const results = normalizeArray(testSuiteEntry.results).filter(result => matchesTestFilter(result, filter));
        if (!results.length) return '';
        const status = testSuiteStatus({ ...testSuiteEntry, results });
        return `
          <details class="tree-card" open>
            <summary>
              <div>
                <strong>${escapeHtml(testSuiteEntry.name)}</strong>
                <div class="muted">Test suite/Test case</div>
              </div>
              <div class="actions">
                <span class="badge ${status}">${status.toUpperCase()}</span>
                <span class="muted">Killed mutants: ${formatNumber(testSuiteEntry.killedMutants)}</span>
              </div>
            </summary>
            <div class="tree-body">
              ${results.map(result => `
                <details class="tree-card" open>
                  <summary>
                    <div>
                      <strong class="mono">${escapeHtml(result.name)}</strong>
                      <div class="muted">Test case</div>
                    </div>
                    <div class="actions">
                      <span class="badge ${testStatus(result)}">${testStatus(result).toUpperCase()}</span>
                      <span class="muted">Detected mutants: ${formatNumber(result.detectedMutants)}${(result.failures || 0) > 0 ? ` · Failures: ${formatNumber(result.failures)}` : ''}</span>
                    </div>
                  </summary>
                  <div class="tree-body">
                    <table>
                      <thead>
                        <tr>
                          <th>Test suite/Test case</th>
                          <th>#Killed mutants/Message</th>
                          <th>Applied mutations</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="status-row-${testStatus(result)}">
                          <td class="mono">${escapeHtml(result.name)}</td>
                          <td>${(result.detectedMutants || 0) > 0 ? formatNumber(result.detectedMutants) : ''}</td>
                          <td></td>
                        </tr>
                        ${normalizeArray(result.mutants).map(mutant => `
                          <tr class="status-row-${classTestStatus(mutant)}">
                            <td class="mono">${escapeHtml(mutant.name)}</td>
                            <td>${escapeHtml(mutant.message || '')}</td>
                            <td>${escapeHtml(normalizeArray(mutant.mutation).join('; '))}</td>
                          </tr>
                        `).join('')}
                      </tbody>
                    </table>
                  </div>
                </details>
              `).join('')}
            </div>
          </details>
        `;
      }).filter(Boolean).join('');
      body.innerHTML = blocks || '<div class="muted">No test results match the selected filter.</div>';
    }

    function renderSuite() {
      if (!reportData || !normalizeArray(reportData.testSuites).length) return;
      const suite = reportData.testSuites[currentSuiteIndex];
      const suiteTabs = normalizeArray(reportData.testSuites).map((entry, index) => `
        <button class="tab-btn ${index === currentSuiteIndex ? 'active' : ''}" data-suite-index="${index}">${escapeHtml(entry.name)}</button>
      `).join('');

      const viewTabs = [
        ['global', 'Global summary'],
        ['class', 'Class results'],
        ['mutator', 'Mutator results'],
        ['test', 'Test results']
      ].map(([key, label]) => `
        <button class="tab-btn ${key === currentView ? 'active' : ''}" data-view="${key}">${escapeHtml(label)}</button>
      `).join('');

      let body = '';
      if (currentView === 'global') body = renderGlobalView(suite);
      if (currentView === 'class') body = renderClassView(suite);
      if (currentView === 'mutator') body = renderMutatorView(suite);
      if (currentView === 'test') body = renderTestView(suite);

      app.innerHTML = `
        <div class="suite-tabs">${suiteTabs}</div>
        <div class="view-tabs">${viewTabs}</div>
        ${body}
      `;

      app.classList.remove('hidden');

      app.querySelectorAll('[data-suite-index]').forEach(btn => {
        btn.addEventListener('click', () => {
          currentSuiteIndex = Number(btn.dataset.suiteIndex);
          renderSuite();
        });
      });
      app.querySelectorAll('[data-view]').forEach(btn => {
        btn.addEventListener('click', () => {
          currentView = btn.dataset.view;
          renderSuite();
        });
      });

      if (currentView === 'class') {
        document.getElementById('classFilter').addEventListener('change', () => paintClassView(suite));
        paintClassView(suite);
      }
      if (currentView === 'mutator') {
        document.getElementById('mutatorFilter').addEventListener('change', () => paintMutatorView(suite));
        paintMutatorView(suite);
      }
      if (currentView === 'test') {
        document.getElementById('testFilter').addEventListener('change', () => paintTestView(suite));
        paintTestView(suite);
      }
    }

    function setMeta() {
      if (!reportData) {
        metaLine.innerHTML = '';
        return;
      }
      const suiteCount = normalizeArray(reportData.testSuites).length;
      metaLine.innerHTML = [
        reportData.projectName ? `<span class="pill blue">Project: ${escapeHtml(reportData.projectName)}</span>` : '',
        `<span class="pill grey">Test suites: ${formatNumber(suiteCount)}</span>`,
        reportData.generatedAt ? `<span class="pill grey">Generated at: ${escapeHtml(reportData.generatedAt)}</span>` : ''
      ].filter(Boolean).join(' ');
    }

    function loadData(data) {
      reportData = data;
      currentSuiteIndex = 0;
      currentView = 'global';
      setMeta();
      renderSuite();
    }

    loadBtn.addEventListener('click', () => {
      try {
        const parsed = JSON.parse(jsonInput.value);
        loadData(parsed);
      } catch (error) {
        alert(`Invalid JSON: ${error.message}`);
      }
    });

    sampleBtn.addEventListener('click', () => {
      jsonInput.value = JSON.stringify(sampleData, null, 2);
      loadData(sampleData);
    });

    fileBtn.addEventListener('click', () => fileInput.click());
    fileInput.addEventListener('change', async () => {
      const file = fileInput.files?.[0];
      if (!file) return;
      const text = await file.text();
      jsonInput.value = text;
      try {
        loadData(JSON.parse(text));
      } catch (error) {
        alert(`Invalid JSON file: ${error.message}`);
      }
    });

    jsonInput.value = JSON.stringify(sampleData, null, 2);
    loadData(sampleData);
